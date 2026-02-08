# Use Java 17 runtime
FROM eclipse-temurin:17-jre

# Set working directory
WORKDIR /app

# Copy jar file
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose port (Render will override)
EXPOSE 8080

# Run the app
CMD ["java", "-jar", "app.jar"]
