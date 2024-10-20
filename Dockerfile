# Step 1: Build the WAR file using Maven
FROM maven:3.8.6-eclipse-temurin-17 AS build

WORKDIR /app
COPY . /app/
RUN mvn clean package

# Step 2: Use Tomcat base image (fixed version)
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","app.jar"]