FROM openjdk:11-jre-slim
COPY build/libs/teacher-service-0.0.1-SNAPSHOT.jar app.jar

ENV PORT=7331
ENV CONFIG_SERVER_URI=http://config-server:7312/
ENV EUREKA_SERVER_URI=http://eureka-server:7311/eureka

EXPOSE 7331/tcp
ENTRYPOINT ["sh", "-c", "java -jar app.jar"]