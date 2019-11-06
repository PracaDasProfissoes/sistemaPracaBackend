FROM maven:3.5-jdk-8-alpine
WORKDIR /app
COPY --from=0 . /app
RUN mvn install

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=1 /app/target/pracadasprofissoes-0.0.1-SNAPSHOT.jar /app

CMD ["java", "-jar", "pracadasprofissoes-0.0.1-SNAPSHOT.jar"]

