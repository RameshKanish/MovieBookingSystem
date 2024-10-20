# Step 1: Build the WAR file using Maven
FROM maven:3.8.6-eclipse-temurin-17 AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Step 2: Use Tomcat base image (fixed version)
FROM tomcat:9-jdk17

WORKDIR /usr/local/tomcat/webapps

# Step 3: Copy the WAR file from the local target folder to Tomcat's webapps folder
COPY target/MovieBooking-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]