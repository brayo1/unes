# Person Web Registry

WebRegistry is a web based registry java API with aim of being utilized in different generic use cases in the health sector (for instance - health facilities, people, institutions, schools, ).

## Installation

Make sure you have MYSQL and Java installed.

Create MySql Database
```bash
CREATE DATABASE webregistry;
```
Open the SpringBoot project and run

or generate jar:
```bash
mvn clean package; java -jar target/RegistryWeb-0.0.1-SNAPSHOT.jar
```


For the report send a `GET` request to `/report`:
* the response code is a PDF Report file