# Step 1: Build the WAR file using Maven
FROM maven:3.8.6-eclipse-temurin-17 AS build

WORKDIR /app
COPY . /app/
RUN mvn clean package -DskipTests

# Step 2: Use Tomcat base image (fixed version)
FROM tomcat:9-jdk17

# Set the working directory inside the Tomcat container
WORKDIR /usr/local/tomcat/webapps

# Step 3: Copy the WAR file from the build stage into Tomcat's webapps folder
COPY --from=build /app/target/MovieBooking-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expose Tomcat's default port
EXPOSE 8080

# Run Tomcat
CMD ["catalina.sh", "run"]