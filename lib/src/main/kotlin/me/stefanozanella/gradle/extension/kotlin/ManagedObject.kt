package me.stefanozanella.gradle.extension.kotlin

import org.gradle.api.model.ObjectFactory
import java.lang.RuntimeException
import javax.inject.Inject
import kotlin.reflect.KProperty

open class ManagedObject<T> @Inject constructor(klass: Class<T>, factory: ObjectFactory, vararg parameters: Any?) {
  private var prop: T = factory.newInstance(klass, *parameters)

  operator fun getValue(thisRef: Any?, property: KProperty<*>): T = prop

  operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
    throw RuntimeException("Managed object cannot be reassigned")
  }
}
