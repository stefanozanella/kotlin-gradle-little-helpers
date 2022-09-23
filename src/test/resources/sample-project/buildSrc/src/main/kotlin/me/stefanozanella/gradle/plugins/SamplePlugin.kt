package me.stefanozanella.gradle.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

class SamplePlugin : Plugin<Project> {
  override fun apply(project: Project) {
    with(project) {
      val config = extensions.create("sample", SampleExtension::class.java)

      tasks.register("printManagedProperty", ManagedPropertyPrinterTask::class.java, config)
      tasks.register("printManagedObject", ManagedObjectPrinterTask::class.java, config)
    }
  }
}
