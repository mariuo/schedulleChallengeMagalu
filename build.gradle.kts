plugins {
	java
	id("org.springframework.boot") version "3.4.3"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.camel"
version = "schedule-1.0"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("com.h2database:h2")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	// https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.5")
	// https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-api
	testImplementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.8.5")
	// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-docker-compose
	implementation("org.springframework.boot:spring-boot-docker-compose:3.4.3")



}

tasks.withType<Test> {
	useJUnitPlatform()
}
