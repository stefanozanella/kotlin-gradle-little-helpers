package me.stefanozanella.gradle.plugins

import me.stefanozanella.gradle.extension.kotlin.managedObject
import me.stefanozanella.gradle.extension.kotlin.managedProperty
import org.gradle.api.model.ObjectFactory
import javax.inject.Inject

open class SampleExtension @Inject constructor(objectFactory: ObjectFactory) {
  var property: String by managedProperty(objectFactory)

  val obj: SampleClass by managedObject(objectFactory, "mud")
}
