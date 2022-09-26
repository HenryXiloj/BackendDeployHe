FROM openjdk:11
EXPOSE 8080
COPY backendHeroku-0.0.1-SNAPSHOT.jar backendHeroku-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","backendHeroku-0.0.1-SNAPSHOT.jar"]
