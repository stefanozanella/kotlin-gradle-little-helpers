plugins {
  `java-library`
  id("me.stefanozanella.sample-plugin")
}

repositories {
  mavenLocal()
}

sample.property = "This is a managed property"
sample.obj.nestedProperty = "ice cream"
