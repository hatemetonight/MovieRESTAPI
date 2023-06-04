FROM openjdk:19-jdk-slim
WORKDIR /app
COPY target/reviews-0.0.1-SNAPSHOT.jar app.jar
COPY script.sql /docker-entrypoint-initdb.d/
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app/app.jar"]
