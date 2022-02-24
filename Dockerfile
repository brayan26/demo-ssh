FROM openjdk:11.0.10-slim
ADD /product /product/
ADD /target/*.jar app.jar
RUN mkdir /log
RUN chgrp -R 0 /log && chmod -R g=u /log
RUN chgrp -R 0 /product && chmod -R g=u /product
ENTRYPOINT ["java","-Djava.security.egd=fileDTO:/dev/./urandom","-jar","/app.jar"]