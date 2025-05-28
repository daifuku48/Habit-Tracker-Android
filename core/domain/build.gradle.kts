plugins {
    alias(libs.plugins.habit.tracker.kotlin.library)
    alias(libs.plugins.kotlin.serialization)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.inject)
    implementation(libs.retrofit.kotlinx.serialization)
}
