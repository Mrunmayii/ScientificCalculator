FROM ubuntu:latest AS build

RUN apt-get update && apt-get install -y \
    maven \
    && apt-get clean

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn clean package

FROM openjdk:17-jdk-slim

WORKDIR /app
COPY --from=build /app/target/ScientificCalculator-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
