plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.detekt.gradle)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "habit.tracker.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }

        register("androidFeature") {
            id = "habit.tracker.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }

        register("androidLibraryCompose"){
            id = "habit.tracker.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }

        register("androidLibrary") {
            id = "habit.tracker.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("daggerHiltAndroid") {
            id = "habit.tracker.dagger.hilt.android"
            implementationClass = "DaggerHiltAndroidConventionPlugin"
        }

        register("daggerHiltCore") {
            id = "habit.tracker.dagger.hilt.core"
            implementationClass = "DaggerHiltCoreConventionPlugin"
        }

        register("kotlinLibrary") {
            id = "habit.tracker.kotlin.library"
            implementationClass = "KotlinLibraryConventionPlugin"
        }

        register("kotlinSerialization") {
            id = "habit.tracker.kotlin.serialization"
            implementationClass = "KotlinSerializationConventionPlugin"
        }

        register("linter") {
            id = "habit.tracker.lint"
            implementationClass = "LintConventionPlugin"
        }
    }
}