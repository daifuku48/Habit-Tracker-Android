import com.danilincorporated.convention.apply
import com.danilincorporated.convention.configureKotlinJvm
import com.danilincorporated.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class KotlinLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.findPlugin("kotlin-jvm").get())
                apply(LintConventionPlugin::class.java)
            }

            configureKotlinJvm()
        }
    }
}