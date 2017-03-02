import org.gradle.api.*
import org.gradle.api.plugins.BasePlugin

class FlamlPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.pluginManager.apply(BasePlugin)

        project.task('text', type: ExtractTextTask)
        project.task('wav', type: ExtractWavTask)
        project.task('lab', type: ExtractLabTask)
    }
}
