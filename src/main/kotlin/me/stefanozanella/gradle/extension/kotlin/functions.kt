package me.stefanozanella.gradle.extension.kotlin

import org.gradle.api.model.ObjectFactory

@Suppress("UNCHECKED_CAST")
inline fun <reified T> managedProperty(factory: ObjectFactory): ManagedProperty<T> =
  factory.newInstance(ManagedProperty::class.java, T::class.java) as ManagedProperty<T>

@Suppress("UNCHECKED_CAST")
inline fun <reified T> optionalManagedProperty(factory: ObjectFactory): OptionalManagedProperty<T> =
  factory.newInstance(OptionalManagedProperty::class.java, T::class.java) as OptionalManagedProperty<T>

@Suppress("UNCHECKED_CAST")
inline fun <reified T> managedListProperty(factory: ObjectFactory): ManagedListProperty<T> =
  factory.newInstance(ManagedListProperty::class.java, T::class.java) as ManagedListProperty<T>

@Suppress("UNCHECKED_CAST")
inline fun <reified K, reified V> managedMapProperty(factory: ObjectFactory): ManagedMapProperty<K, V> =
  factory.newInstance(ManagedMapProperty::class.java, K::class.java, V::class.java) as ManagedMapProperty<K, V>

@Suppress("UNCHECKED_CAST")
inline fun <reified T> managedObject(factory: ObjectFactory, vararg parameters: Any?): ManagedObject<T> =
  factory.newInstance(ManagedObject::class.java, T::class.java, parameters) as ManagedObject<T>
