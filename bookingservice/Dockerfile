# Use a lightweight Java runtime as the base image
FROM openjdk:17-jdk-slim as builder

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Use a smaller image for the final runtime environment
FROM openjdk:17-jre-slim

# Set the working directory in the final container
WORKDIR /app

# Copy the built JAR file from the builder image
COPY --from=builder /app/target/bookingservice-0.0.1-SNAPSHOT.jar booking-service.jar

# Expose the application's port (e.g., 8080)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "booking-service.jar"]
