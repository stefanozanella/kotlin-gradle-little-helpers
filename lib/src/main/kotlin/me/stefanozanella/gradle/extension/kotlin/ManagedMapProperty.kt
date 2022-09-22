package me.stefanozanella.gradle.extension.kotlin

import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.MapProperty
import javax.inject.Inject
import kotlin.reflect.KProperty

open class ManagedMapProperty<K, V> @Inject constructor(
  keyKlass: Class<K>,
  valueKlass: Class<V>,
  factory: ObjectFactory
) {
  private var prop: MapProperty<K, V> = factory.mapProperty(keyKlass, valueKlass)

  operator fun getValue(thisRef: Any?, property: KProperty<*>): Map<K, V> = prop.get()

  operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Map<K, V>) {
    prop.set(value)
  }
}
