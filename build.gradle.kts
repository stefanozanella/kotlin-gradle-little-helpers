plugins {
  kotlin("jvm") version "1.7.10"
  `java-library`
  `maven-publish`
  signing
  id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
}

val mavenRepoUrl: String by project
val mavenSnapshotRepoUrl: String by project

group = "me.stefanozanella"
version = "0.0.2-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
  mavenCentral()
}

dependencies {
  implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation(gradleApi())
  testImplementation(gradleTestKit())
}

testing {
  suites {
    val test by getting(JvmTestSuite::class) {
      useKotlinTest()
    }
  }
}

java {
  withJavadocJar()
  withSourcesJar()
}

tasks.javadoc {
  (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
}

publishing {
  publications {
    create<MavenPublication>("test") {
      from(components["java"])
      artifactId = rootProject.name
      groupId = "me.stefanozanella.testing"
      version = "SNAPSHOT"
    }

    create<MavenPublication>("production") {
      from(components["java"])
      artifactId = rootProject.name

      pom {
        name.set("Kotlin Gradle Little Helpers")
        description.set("A collection of functions providing syntactic sugar for Kotlin-based Gradle plugins.")
        url.set("https://github.com/stefanozanella/kotlin-gradle-little-helpers")

        licenses {
          license {
            name.set("The Apache License, Version 2.0")
            url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
          }
        }

        developers {
          developer {
            id.set("stefanozanella")
            name.set("Stefano Zanella")
            email.set("info@stefanozanella.me")
          }
        }

        scm {
          connection.set("scm:git:git://github.com/stefanozanella/kotlin-gradle-little-helpers.git")
          developerConnection.set("scm:git:git://github.com/stefanozanella/kotlin-gradle-little-helpers.git")
          url.set("https://github.com/stefanozanella/kotlin-gradle-little-helpers")
        }
      }
    }
  }
}

nexusPublishing {
  repositories {
    sonatype {
      nexusUrl.set(uri(mavenRepoUrl))
      snapshotRepositoryUrl.set(uri(mavenSnapshotRepoUrl))
    }
  }
}

signing {
  useGpgCmd()
  sign(publishing.publications["production"])
  sign(configurations.archives.get())
}

// We need to publish the library in whatever state it is before running tests, because the "mock" Gradle project
// loaded in the tests has the library itself as a dependency so if we don't publish it locally the tests won't see
// the changes we make.
tasks.withType<Test> { dependsOn(tasks["publishTestPublicationToMavenLocal"]) }

tasks.create("publishAndReleaseToMavenCentral") {
  dependsOn("publishProductionPublicationToSonatypeRepository", "closeAndReleaseSonatypeStagingRepository")
}
