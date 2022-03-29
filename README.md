# CODEHQ - IOT
````
CODEHQ IOT BACKEND
````

## Development
1. [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
2. [Docker](https://www.docker.com/)
3. [Maven](https://maven.apache.org/)
4. [Mongo](https://www.mongodb.com/)
5. [Docker Compose](https://docs.docker.com/compose/)

### Running
- Run mongodb `docker-compose -f src/main/docker/mongodb.yml`
- Run application `mvn spring-boot:run`

### Testing
- Run test: `mvn clean test`


### Technical Design

Controller <--> Service <--> Model


- Dependency Inversion pattern
- Builder pattern
- 