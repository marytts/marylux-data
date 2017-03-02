import org.gradle.api.tasks.*

class ExtractLabTask extends ExtractTask {
    @OutputDirectory
    def destDir = project.file("$project.buildDir/lab")

    @TaskAction
    def extract() {
        yaml.load(yamlFile.newReader()).each { utterance ->
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
