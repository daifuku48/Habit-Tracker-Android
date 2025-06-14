pluginManagement {
    includeBuild("build-logic") {
        name = "build-logic-convention"
    }
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://jitpack.io")
    }
}
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "Habit-Tracker-Android"
include(":app")
include(":core:architecture")
include(":core:data")
include(":core:database")
include(":core:design-system")
include(":core:domain")
include(":core:network")

include("feature:auth")
include(":core:utils")
include(":feature:splash")
