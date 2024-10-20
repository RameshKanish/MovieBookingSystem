# Step 1: Build the WAR file using Maven
FROM maven:3.8.6-eclipse-temurin-17 AS build

WORKDIR /app
COPY . /app/
RUN mvn clean package -DskipTests  # Skip tests to speed up the build

# Step 2: Use a JAR-based base image
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]