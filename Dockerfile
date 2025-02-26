FROM openjdk:17-jdk AS build

RUN apt-get update && apt-get install -y maven && apt-get clean

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn clean install

FROM openjdk:17-jdk-slim

WORKDIR /app
COPY --from=build /app/target/Scientific-Calculator-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
