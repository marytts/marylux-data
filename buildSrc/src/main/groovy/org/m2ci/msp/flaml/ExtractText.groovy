package org.m2ci.msp.flaml

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.*

import org.yaml.snakeyaml.Yaml

class ExtractText extends DefaultTask {
    @OutputDirectory
    def destDir = project.file("$project.buildDir/text")

    @TaskAction
    def extract() {
        def yamlFile = project.yamlFile
        new Yaml().load(yamlFile.newReader()).each { utterance ->
            project.file("$destDir/${utterance.prompt}.txt").text = utterance.text
        }
    }
}
