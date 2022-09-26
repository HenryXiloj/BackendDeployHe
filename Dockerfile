FROM openjdk:11

EXPOSE 8080

WORKDIR /applications

COPY target/backendHeroku-0.0.1-SNAPSHOT.jar /applications/backendHeroku.jar

ENTRYPOINT ["java","-jar", "backendHeroku.jar"]
