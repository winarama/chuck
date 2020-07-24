# chuck  
  
This is a simple Spring Boot project.

It is an implementation of a typical integration between multiple endpoints in a microservice driven architecture.   

## Overview  
The project utilises two external APIs;   

- Chuck Norris random fact generator API
- Sentiment Analysis API  
  
Operationally, a service object connects to the Chuck Norris API and receives a random fact. This random fact is then passed to a sentiment analysis API, which grades the sentiment of the random fact be be either;
  
- positive  
- negative  
- neutral  
  
[Surprisingly a lot of Chuck Norris facts have a negative sentiment. Who'd a thunk it?]

## Technical
The project is implemented as a Spring Boot application. 

It uses _lombok_ for domain object implementation.

The _circuit breaker_ design pattern is implemented using the _Spring Cloud Netflix Hystrix_ library on the **ChuckService** service. (This enables the project to follow the *build to fail* paradigm.)

## Build

The project uses Gradle.

To build the project use the following command.

```
gradle assemble
```
The project can then be run as an executable jar using the following command.
```
java -jar build/libs/chuck-0.0.1-SNAPSHOT.jar
```
 
 ## Operation

The project has one endpoint which is accessed at;

[http://localhost:8080/api/execute](http://localhost:8080/api/execute)
 
 The project also utilises swagger which can be accessed at the following url;

 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

