package org.m2ci.msp.flaml

import de.undercouch.gradle.tasks.download.DownloadTaskPlugin

import org.gradle.api.*
import org.gradle.api.plugins.BasePlugin

class FlamlPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.pluginManager.apply(BasePlugin)
        project.pluginManager.apply(DownloadTaskPlugin)

        project.extensions.extraProperties.yamlFile = project.file("${project.name}.yaml")
        project.extensions.extraProperties.flacFile = project.file("${project.name}.flac")

        project.task('text', type: ExtractText)
        project.task('wav', type: ExtractWav)
        project.task('lab', type: ExtractLab)
    }
}
