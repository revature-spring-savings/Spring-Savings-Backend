FROM java:8-jdk-alpine

COPY /target/SpringBanking-SNAPSHOT.jar /restapi.jar

CMD ["java","-jar","restapi.jar"]