FROM openjdk:18-jdk-alpine

COPY build/libs/apache-velocity-testbed-1.0-SNAPSHOT.jar app/app.jar

EXPOSE 8080

CMD java -jar app/app.jar
