package me.stefanozanella.gradle.extension.kotlin

import org.gradle.testkit.runner.TaskOutcome
import kotlin.test.Test
import kotlin.test.assertEquals

class HelperFunctionsTest: GradleRunnerTest() {
  @Test
  fun `managedProperty creates a new Gradle Property`() {
    val taskName = "printManagedProperty"
    val build = runBuildTask(taskName)

    assertEquals(TaskOutcome.SUCCESS, build.task(":$taskName")?.outcome)
    assertEquals("This is a managed property", build.output.findTaskOutput())
  }

  @Test
  fun `managedObject creates a new managed instance of the specified type`() {
    val taskName = "printManagedObject"
    val build = runBuildTask(taskName)

    assertEquals(TaskOutcome.SUCCESS, build.task(":$taskName")?.outcome)
    assertEquals("How fun it is to eat ice cream!", build.output.findTaskOutput())
  }
}
