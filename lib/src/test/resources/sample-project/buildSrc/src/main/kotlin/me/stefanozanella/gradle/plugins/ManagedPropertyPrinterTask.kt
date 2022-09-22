package me.stefanozanella.gradle.plugins

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import javax.inject.Inject

open class ManagedPropertyPrinterTask @Inject constructor(private val config: SampleExtension) : DefaultTask() {
  @TaskAction
  fun action() = printMarkedOutput(config.property)
}
