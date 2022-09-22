package me.stefanozanella.gradle.extension.kotlin

import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import javax.inject.Inject
import kotlin.reflect.KProperty

open class OptionalManagedProperty<T> @Inject constructor(klass: Class<T>, factory: ObjectFactory) {
  private var prop: Property<T> = factory.property(klass)

  operator fun getValue(thisRef: Any, property: KProperty<*>): T? = prop.orNull

  operator fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
    prop.set(value)
  }
}
