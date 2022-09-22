package me.stefanozanella.gradle.extension.kotlin

import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.ListProperty
import javax.inject.Inject
import kotlin.reflect.KProperty

open class ManagedListProperty<T> @Inject constructor(klass: Class<T>, factory: ObjectFactory) {
  private var prop: ListProperty<T> = factory.listProperty(klass)

  operator fun getValue(thisRef: Any?, property: KProperty<*>): List<T> = prop.get()

  operator fun setValue(thisRef: Any?, property: KProperty<*>, value: List<T>) {
    prop.set(value)
  }
}
