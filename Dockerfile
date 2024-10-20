# Step 1: Build the WAR file using Maven
FROM maven:3.8.6-eclipse-temurin-17 AS build

# Set the working directory (it can be any valid directory, not necessarily /app)
WORKDIR /build

# Copy the pom.xml and source code to the container
COPY pom.xml .
COPY src ./src

# Run Maven to build the project and package the WAR file
RUN mvn clean package -DskipTests

# Step 2: Use Tomcat base image
FROM tomcat:9-jdk17

# Set the working directory in the Tomcat container
WORKDIR /usr/local/tomcat/webapps

# Copy the WAR file from the build stage to Tomcat's webapps folder
COPY --from=build /build/target/MovieBooking-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080 for Tomcat to listen on
EXPOSE 8080

# Start Tomcat when the container is run
CMD ["catalina.sh", "run"]