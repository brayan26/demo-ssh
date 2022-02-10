## Microservice
Spring Boot App

### Table of Contents
* [Architecture Stack](#architecture)
* [Summary](#summary)
* [Requirements](#requirements)
* [Configuration](#configuration)
* [Project contents](#project-contents)
* [Run](#run)


### Architecture
Clean Architecture + Hexagonal Architecture

### Summary

This is a Spring boot microservice with ssh connect

### Requirements

* [Maven](https://maven.apache.org/install.html)
* Java 11: Any compliant JVM should work.
    * [Java 11 JDK from Oracle](https://www.oracle.com/co/java/technologies/javase/jdk11-archive-downloads.html)


### Configuration

Capabilities are provided through dependencies in the pom.xml fileDTO and the application.yml for the main properties.

### Project contents

The ports are set to the defaults of 8081 for http.

### Run

To build and run the application using Maven:

```sh
1. `mvn clean compile install`
2. `java -jar ./target/*.jar`
```

and using Docker in Linux OS:

```sh
1. sudo mvn install dockerfile:build 
2. sudo docker run -d --name ssh-connect-backend -p 54322:8081 -t spring-ssh/demo-shell
```
