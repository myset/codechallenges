# About
Project contains a Spring Boot application that reads data from a Kafka topic, processes
it, and stores it in a database. The application is able to handle large volumes of
data efficiently.


**Tasks**
1. The application use Spring Boot and Kafka libraries to interact with the Kafka
   broker.
2. The application is able to handle any errors that may occur while reading or
   processing the data.
3. The application use a H2 database (in memory) to store the processed data.
4. The application is able to read data from a Kafka broker and store it in a
   database.
5. The application process the data in batches to improve performance.


## Running
This application can be built and tested with Java using [Maven](https://maven.apache.org/) and your favourite IDE

!!! Before running please update application.properties with your own coordinates.


## Endpoints

- GET /hello/ - Sample hello service with output plain text Ex. /hello/World 
- GET /healthcheck - Service healthcheck with output json
- GET /error - Service error handler with json output
  - Output a standardized json
  - Console error stack trace
- GET /kafka/messagecontent - Kafka message producer endpoint. 
  - When success output is plain text message content.
  - When success, message appear in the console output
  - When success, filtered message (staring with DB-) appear in the console, and is inserted into H2 database using batch with a predefined configurable size.
   
- GET /h2-ui - H2 database WEBUI check with your coordinates

### Enjoy ;)