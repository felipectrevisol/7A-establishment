FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/todo-app-0.0.0.jar todo-app.jar
ENTRYPOINT ["java","-jar","/todo-app.jar"]