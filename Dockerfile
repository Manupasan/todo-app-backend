# Use OpenJDK 17 as base image
FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/todo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]