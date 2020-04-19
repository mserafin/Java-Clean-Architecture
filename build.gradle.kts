plugins {
    id("org.springframework.boot") version "2.2.6.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("io.swagger.core.v3.swagger-gradle-plugin") version "2.1.2"
    kotlin("jvm") version "1.3.71"
    kotlin("plugin.spring") version "1.3.71"
}

group = "com.mserafin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
}

dependencies {
    // Spring Boot
    implementation("org.springframework.boot", "spring-boot-devtools")
    implementation("org.springframework.boot", "spring-boot-starter-web")
    implementation("org.springframework.boot", "spring-boot-starter-jetty")

    // Additional libs
    implementation("org.apache.commons", "commons-lang3")

    // Swagger
    implementation("io.swagger", "swagger-core", "1.5.21")
    implementation("io.springfox", "springfox-swagger2", "2.9.2")
    implementation("io.springfox", "springfox-swagger-ui", "2.9.2")


    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}