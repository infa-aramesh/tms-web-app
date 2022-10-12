FROM tomcat:jre8-openjdk-slim-buster


RUN apt-get update
RUN apt-get install -y wget

 
COPY ./build/libs/rest-service-0.0.1-SNAPSHOT.jar rest-service-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java","-jar","rest-service-0.0.1-SNAPSHOT.jar"]  
