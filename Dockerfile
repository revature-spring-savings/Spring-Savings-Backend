FROM java:8-jdk-alpine

COPY /target/web-services-restful-0.0.1-SNAPSHOT.jar /restapi.jar

CMD ["java","-jar","restapi.jar"]