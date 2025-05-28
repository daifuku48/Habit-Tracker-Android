plugins {
    alias(libs.plugins.habit.tracker.android.library.compose)
}

dependencies {
    implementation(projects.core.designSystem)
    implementation(projects.core.domain)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.kotlinx.collections.immutable)
}
