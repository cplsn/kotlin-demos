plugins {
  id("org.springframework.boot") version "2.7.2"
  id("io.spring.dependency-management") version "1.0.12.RELEASE"
  kotlin("jvm") version "1.7.10"
  kotlin("plugin.spring") version "1.7.10"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
  mavenCentral()

  maven {
    url = uri("https://artifactory.nyt.net/artifactory/spg-maven-common")
  }
}

dependencies {
  implementation("com.nytimes.spg:spg-spring-boot-starter:1.5.15")
  implementation("com.nytimes.spg:settlements-service-server:0.0.28")

//  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "17"
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
