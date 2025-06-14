import com.android.build.gradle.internal.api.ApkVariantOutputImpl

plugins {
    alias(libs.plugins.habit.tracker.android.application.compose)
    alias(libs.plugins.habit.tracker.kotlin.serialization)
}

android {
    namespace = "com.danilincorporated.habit_tracker_android"

    defaultConfig {
        applicationId = "com.danilincorporated.habit_tracker_android"
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildOutputs.all {
        val outputImpl = this as? ApkVariantOutputImpl
        val buildType = outputImpl?.name
        val versionName = android.defaultConfig.versionName
        val apkFileName = "habit-tracker-$buildType-$versionName.apk"
        outputImpl?.outputFileName = apkFileName
    }
}

dependencies {
    implementation(projects.feature.splash)
    implementation(projects.feature.auth)

    implementation(projects.core.designSystem)
    implementation(projects.core.architecture)
    implementation(projects.core.domain)
    implementation(libs.kotlinx.collections.immutable)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.lifecycle.viewmodel.navigation3)
    implementation(libs.kotlinx.serialization.core)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation3.ui.android)
}