import org.gradle.api.DefaultTask
import org.gradle.api.tasks.*

import org.yaml.snakeyaml.Yaml

class ExtractTask extends DefaultTask {
    @InputFiles
    def yamlFile = project.yamlFile

    def yaml = new Yaml()
}
