import com.android.build.api.dsl.LibraryExtension
import com.danilincorporated.convention.apply
import com.danilincorporated.convention.configureAndroidCompose
import com.danilincorporated.convention.configureCompileOptions
import com.danilincorporated.convention.configureKotlinAndroid
import com.danilincorporated.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

internal class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.findPlugin("android-library").get())
                apply(libs.findPlugin("kotlin-android").get())
                apply(LintConventionPlugin::class.java)
            }

            extensions.getByType<LibraryExtension>().apply {
                configureCompileOptions()
                configureAndroidCompose(commonExtension = this)
                configureKotlinAndroid(extension = this)
            }
        }
    }
}
