plugins {
    alias(libs.plugins.habit.tracker.android.library)
    alias(libs.plugins.habit.tracker.dagger.hilt.android)
    alias(libs.plugins.ksp)
}

dependencies {
    implementation(libs.room.compiler)
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)
}
