plugins {
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "com.gbc"
version = "0.0.1-SNAPSHOT"

repositories { mavenCentral() }

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.kafka:spring-kafka")
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:2.1.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
