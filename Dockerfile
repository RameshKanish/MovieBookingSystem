# Step 1: Build the WAR file using Maven
FROM maven:3.8.6-eclipse-temurin-17 AS build

WORKDIR /build

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Step 2: Use Tomcat base image
FROM tomcat:9-jdk17

WORKDIR /usr/local/tomcat/webapps

COPY --from=build /build/target/MovieBooking-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080 for Tomcat to listen on
EXPOSE 8080

# Start Tomcat when the container is run
CMD ["catalina.sh", "run"]