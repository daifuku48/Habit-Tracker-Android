plugins {
    alias(libs.plugins.habit.tracker.android.feature)
}

dependencies {
    implementation(projects.core.domain)
    implementation(libs.kotlinx.collections.immutable)
}
