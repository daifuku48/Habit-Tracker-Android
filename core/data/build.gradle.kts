plugins {
    alias(libs.plugins.habit.tracker.android.library)
    alias(libs.plugins.habit.tracker.kotlin.serialization)
    alias(libs.plugins.habit.tracker.dagger.hilt.android)
}

dependencies {
//    implementation(projects.core.util)
    implementation(projects.core.domain)
    implementation(projects.core.database)
//    implementation(projects.core.bluetooth)
    implementation(projects.core.network)
    implementation(libs.okhttp)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.play.services)
//    implementation(platform(libs.firebase.bom))
//    implementation(libs.firebase.messaging)
}
