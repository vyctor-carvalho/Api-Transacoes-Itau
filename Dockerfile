FROM maven:3.9.9-eclipse-temurin-21-alpine AS bulder
WORKDIR /app
COPY . .
RUN mvn package -DskipTests
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=bulder app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]