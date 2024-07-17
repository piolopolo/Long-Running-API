# Long-Running-API

## Overview
This project demonstrates asynchronous processing using Spring Boot. Users can start a long-running process and check its status without having to wait for it to complete.

## Setup
1. Clone the repository.
2. Navigate to the project directory.
3. Run the application using `./mvnw spring-boot:run` or your IDE's run configuration.

## Endpoints
### Start Process
- **URL:** `/api/start-process`
- **Method:** `POST`
- **Description:** Starts a new background process.
- **Response:** Returns the process ID.

### Check Process Status
- **URL:** `/api/process-status/{id}`
- **Method:** `GET`
- **Description:** Checks the status of the process with the given ID.
- **Response:** Returns the status of the process.

## Example Usage
1. Start a process:
   ```bash
   curl -X POST http://localhost:8080/api/start-process

2. Check process status:
 ```bash
   curl -X GET http://localhost:8080/api/process-status/{processId}
