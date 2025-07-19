# Stage 1: Build the application
FROM maven:3.9.6-eclipse-temurin-17 as builder

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests
  
  # Stage 2: Run the application
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app
  
  # Copy the jar from the builder stage
COPY --from=builder /app/target/*.jar app.jar
  
  # Expose the application's port (optional, for clarity)
EXPOSE 8080
  
  # Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
