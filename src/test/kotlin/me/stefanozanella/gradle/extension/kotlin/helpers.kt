package me.stefanozanella.gradle.extension.kotlin

import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.GradleRunner
import java.io.File

fun String.findTaskOutput() = this
  .lines()
  .find { it.startsWith("OUTPUT: ") }
  ?.removePrefix("OUTPUT: ")

abstract class GradleRunnerTest {
  fun runBuildTask(name: String): BuildResult = GradleRunner
    .create()
    .withProjectDir(File(this.javaClass.classLoader.getResource("sample-project").toURI()))
    .withArguments(name)
    .build()
}
