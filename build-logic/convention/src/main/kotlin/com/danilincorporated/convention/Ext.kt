package com.danilincorporated.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.plugins.PluginManager
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.plugin.use.PluginDependency


internal val JAVA_VERSION = JavaVersion.VERSION_21

internal val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

internal fun PluginManager.apply(plugin: Provider<PluginDependency>) {
    apply(plugin.get().pluginId)
}

internal fun Project.configureAndroidCompose(commonExtension: CommonExtension<*, *, *, *, *, *>) {
    commonExtension.apply {
        pluginManager.apply(libs.findPlugin("kotlin-compose").get())

        buildFeatures {
            compose = true
        }
        dependencies {
            add("implementation", platform(libs.findLibrary("androidx-compose-bom").get()))
            add("implementation", libs.findLibrary("androidx-ui-tooling-preview").get())
            add("debugImplementation", libs.findLibrary("androidx-ui-tooling").get())
        }
    }
}

internal fun CommonExtension<*, *, *, *, *, *>.configureCompileOptions(javaVersion: JavaVersion = JAVA_VERSION) {
    compileOptions {
        isCoreLibraryDesugaringEnabled = true

        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }
}

internal fun Project.configureKotlinAndroid(extension: CommonExtension<*, *, *, *, *, *>) =
    extension.apply {
        val moduleName = path.split(":").drop(2).joinToString(".").replace("-", ".")
        namespace = buildString {
            append("com.danilincorporated.habit_tracker_android")
            if (moduleName.isNotEmpty()) append(".$moduleName")
        }
        compileSdk = libs.findVersion("compile-sdk").get().requiredVersion.toInt()
        defaultConfig {
            minSdk = libs.findVersion("min-sdk").get().requiredVersion.toInt()
        }

        dependencies {
            add("coreLibraryDesugaring", libs.findLibrary("android-desugaring").get())
        }
    }

internal fun Project.configureKotlinJvm(javaVersion: JavaVersion = JAVA_VERSION) {
    extensions.configure<JavaPluginExtension> {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }
}

internal fun Project.configureAndroidUiTest(extension: CommonExtension<*, *, *, *, *, *>) {
    extension.apply {
        compileSdk = libs.findVersion("compile-sdk").get().requiredVersion.toInt()

        defaultConfig {
            minSdk = libs.findVersion("min-sdk").get().requiredVersion.toInt()
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        buildFeatures {
            compose = true
        }

        testOptions {
            animationsDisabled = true
            execution = "ANDROIDX_TEST_ORCHESTRATOR"
        }

        packaging.resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"

        dependencies {
            // Compose UI Test
            add("androidTestImplementation", libs.findLibrary("androidx-ui-test-junit4").get())
            add("debugImplementation", libs.findLibrary("androidx-ui-test-manifest").get())

            // Espresso
            add("androidTestImplementation", libs.findLibrary("androidx-espresso-core").get())

            // JUnit
            add("androidTestImplementation", libs.findLibrary("androidx-junit").get())

            // Hilt testing
            add("androidTestImplementation", libs.findLibrary("hilt-android-testing").get())
            add("kaptAndroidTest", libs.findLibrary("dagger-hilt-android-compiler").get())

            // Orchestrator
            add("androidTestUtil", "androidx.test:orchestrator:1.4.2")
        }
    }
}
