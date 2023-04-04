FROM adoptopenjdk/openjdk11:latest
ADD target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]