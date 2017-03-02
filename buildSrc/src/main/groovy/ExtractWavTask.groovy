import org.gradle.api.tasks.*

class ExtractWavTask extends ExtractTask {
    @OutputDirectory
    def destDir = project.file("$project.buildDir/wav")

    @TaskAction
    def extract() {
        yaml.load(yamlFile.newReader()).each { utterance ->
            project.exec {
                commandLine 'sox',
                        project.audioFile,
                        project.file("$destDir/${utterance.prompt}.wav"),
                        'trim',
                        utterance.start,
                        '=' + utterance.end
            }
        }
    }
}
