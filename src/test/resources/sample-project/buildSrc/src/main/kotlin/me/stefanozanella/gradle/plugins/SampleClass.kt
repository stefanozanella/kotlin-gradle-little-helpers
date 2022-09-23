package me.stefanozanella.gradle.plugins

import javax.inject.Inject

open class SampleClass @Inject constructor(var nestedProperty: String) {
  fun processedProperty() = "How fun it is to eat $nestedProperty!"
}
