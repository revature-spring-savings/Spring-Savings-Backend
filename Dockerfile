FROM java:8-jdk-alpine

COPY /target/SpringBanking-0.0.1-SNAPSHOT.jar /restapi.jar

CMD ["java","-jar","restapi.jar"]

