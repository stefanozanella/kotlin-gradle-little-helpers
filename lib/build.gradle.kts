plugins {
  kotlin("jvm") version "1.7.10"
  `java-library`
  `maven-publish`
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation(gradleApi())
  testImplementation(gradleTestKit())
}

group = "me.stefanozanella"
version = "0.0.1-SNAPSHOT"

testing {
  suites {
    val test by getting(JvmTestSuite::class) {
      useKotlinTest()
    }
  }
}

publishing {
  publications {
    create<MavenPublication>("test") {
      from(components["kotlin"])
      artifactId = rootProject.name
      groupId = "me.stefanozanella.testing"
      version = "SNAPSHOT"
    }
  }
}
