import com.android.build.gradle.internal.api.ApkVariantOutputImpl

plugins {
    alias(libs.plugins.habit.tracker.android.application.compose)
    alias(libs.plugins.habit.tracker.kotlin.serialization)
}

android {
    namespace = "com.danilincorporated.habit_tracker_android"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.danilincorporated.habit_tracker_android"
        minSdk = 24
        targetSdk = 35
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
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
    implementation(projects.core.designSystem)
    implementation(projects.core.architecture)
    implementation(projects.core.domain)
    implementation(libs.kotlinx.collections.immutable)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.hilt.navigation.compose)
}