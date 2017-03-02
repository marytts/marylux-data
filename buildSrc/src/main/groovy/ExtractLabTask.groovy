import org.gradle.api.DefaultTask
import org.gradle.api.tasks.*

import org.yaml.snakeyaml.Yaml

class ExtractLabTask extends DefaultTask {
    @OutputDirectory
    def destDir = project.file("$project.buildDir/lab")

    @TaskAction
    def extract() {
        def yamlFile = project.yamlFile
        new Yaml().load(yamlFile.newReader()).each { utterance ->
            if (utterance.segments) {
                project.file("$destDir/${utterance.prompt}.lab").withWriter { lab ->
                    lab.println "#"
                    def end = 0f
                    utterance.segments.each { segment ->
                        end += segment.dur as float
                        lab.println "\t${end.round(3)}\t125\t$segment.lab"
                    }
                }
            }
        }
    }
}
