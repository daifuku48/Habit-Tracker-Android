import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(AndroidLibraryComposeConventionPlugin::class.java)
                apply(DaggerHiltAndroidConventionPlugin::class.java)
                apply(LintConventionPlugin::class.java)
            }

            dependencies {
                add("implementation", project(":core:design-system"))
                add("implementation", project(":core:architecture"))
            }
        }
    }
}
