# Use an official OpenJDK runtime as a parent image
FROM maven:3.8.6-openjdk-17 as builder

# Set the working directory inside the container
WORKDIR /app

# Copy the project files into the container
COPY . .

# Build the application JAR file
RUN mvn clean package -DskipTests

# Use a smaller JDK runtime for the final image
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
