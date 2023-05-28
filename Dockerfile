FROM eclipse-temurin:20-jdk-alpine
ARG DOCKER_TAG
ENV APP_VERSION=$DOCKER_TAG
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]