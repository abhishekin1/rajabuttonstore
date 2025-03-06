# Use an official OpenJDK runtime as a parent image

# Set the working directory inside the container
WORKDIR /app


# Expose the application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
