# Step 1: Use an official Maven image to build the project
FROM maven:3.8.6-eclipse-temurin-17 AS build

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the pom.xml and the source code into the container
COPY pom.xml .
COPY src ./src

# Step 4: Build the project using Maven (skip tests for faster build)
RUN mvn clean package -DskipTests

# Step 5: Check the contents of the target directory to confirm the WAR file
RUN ls -la /app/target

# Step 6: Use Tomcat base image to run the WAR file
FROM tomcat:9.0.65-jdk17-openjdk

# Step 7: Set the working directory for Tomcat
WORKDIR /usr/local/tomcat/webapps

# Step 8: Copy the WAR file from the build container to Tomcat's webapps folder
COPY --from=build /app/target/MovieBooking-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Step 9: Expose Tomcat's default port (8080)
EXPOSE 8080

# Step 10: Start Tomcat (this is the default entrypoint for the tomcat image)
CMD ["catalina.sh", "run"]