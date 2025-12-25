FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

COPY target/XWikiFAQ-1.0.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]