package com.example.wellness;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
class IntegrationTest {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("wellnessdb")
            .withUsername("postgres")
            .withPassword("password");

    @Container
    static GenericContainer<?> redis = new GenericContainer<>("redis:latest").withExposedPorts(6379);

    @Test
    void contextLoads() {
        System.out.println("✅ Wellness service started with Postgres + Redis TestContainers");
    }
}
