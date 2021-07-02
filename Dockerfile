FROM openjdk

WORKDIR /app

COPY target/avaliacao-api-0.0.1-SNAPSHOT.jar /app/avaliacao-api.jar

ENTRYPOINT ["java", "-jar", "avaliacao-api.jar"]