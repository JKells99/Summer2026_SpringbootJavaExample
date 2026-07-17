# Stage 1: Build the application with Maven + Java 24
FROM maven:3.9-eclipse-temurin-24 AS build
WORKDIR /workspace/app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the application on Java 24
FROM eclipse-temurin:24-jre-alpine
WORKDIR /app
COPY --from=build /workspace/app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]