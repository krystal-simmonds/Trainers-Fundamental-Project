FROM maven:3.3.9 AS build-stage
COPY . /build
WORKDIR /build
RUN mvn clean package

FROM java:8 AS runtime
WORKDIR /opt/trainers
COPY --from=build-stage /build/target/trainers.jar app.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "app.jar"]
