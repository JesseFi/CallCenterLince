import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

plugins {
	id("org.springframework.boot") version "3.0.0-SNAPSHOT"
	id("io.spring.dependency-management") version "1.0.12.RELEASE"
	id("org.cyclonedx.bom") version "1.7.0"

	kotlin("plugin.serialization") version "1.7.10"
	kotlin("jvm") version "1.7.10"
	kotlin("plugin.spring") version "1.7.10"
}

group = "br.com.lince.singe"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
	maven { url = uri("https://jitpack.io") }
}

dependencies {
	implementation("com.github.f4b6a3:uuid-creator:5.1.2")

	// GCP dependencies
	//implementation("com.google.cloud:spring-cloud-gcp-dependencies:3.4.0")
	//implementation("com.google.cloud:spring-cloud-gcp-starter-sql-postgresql:3.4.0")

	// Standard spring boot libraries
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-mail")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("com.auth0:java-jwt:4.2.1")

	// Kotlin specific libraries
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")

	// Database dependencies
	runtimeOnly("org.postgresql:postgresql")

	// Development only libraries
	developmentOnly("org.springframework.boot:spring-boot-devtools")

	// Kotlin Exposed dependencies
	val exposedVersion = "0.40.1"
	implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
	implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
	implementation("org.jetbrains.exposed:exposed-java-time:$exposedVersion")
	implementation("org.jetbrains.exposed:exposed-spring-boot-starter:$exposedVersion")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.bootBuildImage {
}

// Plugin page: https://github.com/CycloneDX/cyclonedx-gradle-plugin
// Plugin license: Apache 2.0 (https://github.com/CycloneDX/cyclonedx-gradle-plugin/blob/master/LICENSE)
tasks.cyclonedxBom {
	setIncludeConfigs(listOf("runtimeClasspath"))
	setSkipConfigs(listOf("compileClasspath", "testCompileClasspath"))
	setProjectType("application")
	setSchemaVersion("1.4")
	setDestination(project.file("build/reports"))
	setOutputName("bom")
	setOutputFormat("all")
}
