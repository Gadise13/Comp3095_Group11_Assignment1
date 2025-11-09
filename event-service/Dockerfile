# Use Java 21 base image
FROM eclipse-temurin:21-jdk

# Set working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/*.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]