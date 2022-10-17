Java - Authentication API
=========================

Java - Authentication API

- [Github repository](https://github.com/roldanwilfrido/test)

# Software Requirements

Project with the latest available versions of the following:

* Spring Boot 3.0.0-M5+
* Java 17 - **Check out [SDKMAN!](https://sdkman.io/)**
* Jakarta EE
* H2
* Gradle 7.5+


## Setup for IntelliJ

* Install "lombok" plugin & Enable: Settings -> Compiler -> Annotation Processor -> Enable annotation processing


## Running application

1. Compiling and running unit tests
```
./gradlew clean test bootJar
```
2. Starting the App
```
./gradlew bootRun
```

## Using application

### - Login

<b>URL</b>: [POST] http://localhost:8081/users/login
```json
{
  "username": "Andrei",
  "password": "andreitest"
}
```
Response: 200
```json
{
  "result": true
}
```

### - Save

<b>URL</b>: [POST] http://localhost:8081/users/save
```json
{
  "username": "upstack",
  "password": "test123"
}
```
Response: 200
```json
{
  "result": true
}
```

## Exception handler 

* Case #1 >> Empty/Nullable fields:

Response:
```json
{
  "time": "2022-10-17T15:02:19.854481Z",
  "status": 400,
  "message": "Username and Password must be filled. Please check."
}
```

* Case #2: Trying to save user credentials that already exist:
 
<b>URL</b>: [POST] localhost:8081/users/save
```json
{
  "username": "Andrei",
  "password": "andreitest"
}
```
Response:
```json
{
  "time": "2022-10-17T15:04:50.464917Z",
  "status": 422,
  "message": "The user credentials already exist!"
}
```

## Details

* Controller (Spring web)
* Service (Spring Framework)
* Validations (NoTNull, Empty - Jakarta EE)
* Exception handler (Spring web)