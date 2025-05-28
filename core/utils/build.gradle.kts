plugins {
    alias(libs.plugins.habit.tracker.kotlin.library)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.inject)
    implementation(libs.retrofit.kotlinx.serialization)
}
