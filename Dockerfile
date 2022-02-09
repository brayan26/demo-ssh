FROM openjdk:11.0.10-slim
ADD /target/*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=fileDTO:/dev/./urandom","-jar","/app.jar"]