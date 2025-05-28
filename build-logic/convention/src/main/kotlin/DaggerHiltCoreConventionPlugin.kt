import com.danilincorporated.convention.apply
import com.danilincorporated.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal class DaggerHiltCoreConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(libs.findPlugin("ksp").get())

            dependencies {
                add("implementation", libs.findLibrary("dagger-hilt-core").get())
                add("ksp", libs.findLibrary("dagger-hilt-compiler").get())
            }
        }
    }
}
