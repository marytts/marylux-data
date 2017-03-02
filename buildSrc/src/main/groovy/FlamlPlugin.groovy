import de.undercouch.gradle.tasks.download.DownloadTaskPlugin

import org.gradle.api.*
import org.gradle.api.plugins.BasePlugin

class FlamlPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.pluginManager.apply(BasePlugin)
        project.pluginManager.apply(DownloadTaskPlugin)

        project.extensions.extraProperties.yamlFile = project.file("${project.name}.yaml")

        project.task('text', type: ExtractTextTask)
        project.task('wav', type: ExtractWavTask)
        project.task('lab', type: ExtractLabTask)
    }
}
