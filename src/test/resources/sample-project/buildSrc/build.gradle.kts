plugins {
  kotlin("jvm") version "1.6.21"
  `java-gradle-plugin`
  `kotlin-dsl`
}

repositories {
  mavenCentral()
  mavenLocal()
}

dependencies {
  implementation(gradleApi())
  implementation("me.stefanozanella.testing:kotlin-gradle-little-helpers:SNAPSHOT")
}

gradlePlugin {
  plugins {
    create("sample-plugin") {
      id = "me.stefanozanella.sample-plugin"
      implementationClass = "me.stefanozanella.gradle.plugins.SamplePlugin"
      isAutomatedPublishing = false
    }
  }
}
