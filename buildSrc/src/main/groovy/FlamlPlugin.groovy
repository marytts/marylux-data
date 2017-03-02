import org.gradle.api.*
import org.gradle.api.plugins.BasePlugin

class FlamlPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.pluginManager.apply(BasePlugin)
    }
}
