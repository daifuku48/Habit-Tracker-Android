plugins {
    alias(libs.plugins.habit.tracker.android.library)
    alias(libs.plugins.habit.tracker.kotlin.serialization)
    alias(libs.plugins.habit.tracker.dagger.hilt.android)
}

android {
    buildTypes {
        debug {
            buildConfigField("String", "BASE_URL", "https://dev.frekuent.com/mobile/v1/")
        }
        release {
            buildConfigField("String", "BASE_URL", "https://frekuent.com/mobile/v1/")
        }
    }
    buildFeatures.buildConfig = true
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.retrofit.kotlinx.serialization)

    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)
    debugImplementation(libs.chucker.library)
    releaseImplementation(libs.chucker.library.no.op)
    implementation(libs.coil.network.okhttp)

    implementation(projects.core.database)
    implementation(projects.core.domain)
}
