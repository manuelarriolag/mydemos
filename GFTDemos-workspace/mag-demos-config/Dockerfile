FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/mag-demos-config-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'

EXPOSE 9898

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]

