package org.m2ci.msp.flaml

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.*

import org.yaml.snakeyaml.Yaml

class ExtractWav extends DefaultTask {
    @OutputDirectory
    def destDir = project.file("$project.buildDir/wav")

    @TaskAction
    def extract() {
        def yamlFile = project.yamlFile
        new Yaml().load(yamlFile.newReader()).each { utterance ->
            project.exec {
                commandLine 'sox',
                        project.flacFile,
                        project.file("$destDir/${utterance.prompt}.wav"),
                        'trim',
                        utterance.start,
                        '=' + utterance.end
            }
        }
    }
}
