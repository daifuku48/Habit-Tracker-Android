import com.danilincorporated.convention.apply
import com.danilincorporated.convention.libs
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

internal class LintConventionPlugin : Plugin<Project>  {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(libs.findPlugin("detekt").get())

            configure<DetektExtension> {
                toolVersion = "1.23.7"
                source.setFrom("src/main/java", "src/main/kotlin")
                config.setFrom(rootProject.file("config/detekt/detekt.yml"))
                autoCorrect = true
                buildUponDefaultConfig = true

                dependencies {
                    add("detektPlugins", libs.findLibrary("detekt-formatting").get())
                }
            }
        }
    }
}