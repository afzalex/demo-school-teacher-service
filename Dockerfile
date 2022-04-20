FROM openjdk:11-jre-slim
COPY build/libs/teacher-service-0.0.1-SNAPSHOT.jar app.jar

ENV PORT=8331
ENV CONFIG_SERVER_URI=http://config-server:8312/
ENV EUREKA_SERVER_URI=http://eureka-server:8311/eureka

EXPOSE 8331/tcp
ENTRYPOINT ["sh", "-c", "java -jar app.jar"]