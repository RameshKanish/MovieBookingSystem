# Step 1: Use an official Maven image to build the project
FROM maven:3.8.6-eclipse-temurin-17 AS build

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the pom.xml and the source code into the container
COPY pom.xml .
COPY src ./src

# Step 4: Build the project using Maven
# Including tests here. You can skip tests by using `-DskipTests` if desired.
RUN mvn clean package -DskipTests

# Step 5: Use a lightweight JDK image to run the Spring Boot application
FROM eclipse-temurin:17-jdk-alpine

# Step 6: Set the working directory for the runtime environment
WORKDIR /app

# Step 7: Copy the built .jar file from the Maven build container
COPY --from=build /app/target/MovieBooking-0.0.1-SNAPSHOT.jar /app/app.jar

# Step 8: Expose the port that the application runs on (default 8080)
EXPOSE 8080

# Step 9: Run the application using java -jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]