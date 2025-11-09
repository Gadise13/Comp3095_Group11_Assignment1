FROM eclipse-temurin:21-jdk
WORKDIR /app
ARG JAR_FILE=build/libs/goal-tracking-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
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