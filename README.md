# HemoPulse Emergency Donor Center API

This project implements a Spring Boot REST API for managing blood donors in the HemoPulse Emergency Donor Center.

## Features
- Register a donor
- Retrieve all donors
- Retrieve one donor by ID
- Update a donor using PUT
- Partially update a donor using PATCH
- Delete a donor
- Uses Spring Data JPA and an in-memory H2 database

## Base URL
http://localhost:8080/api/donors

## Endpoints
- GET /api/donors
- GET /api/donors/{id}
- POST /api/donors
- PUT /api/donors/{id}
- PATCH /api/donors/{id}
- DELETE /api/donors/{id}

## Sample JSON for POST
{
  "fullName": "Aarav Sharma",
  "bloodGroup": "O+",
  "phoneNumber": "9876543210",
  "email": "aarav@example.com",
  "city": "Bengaluru",
  "lastDonationDate": "2025-09-12"
}

## Run the application
From the project root:

mvn spring-boot:run

Then open Postman and test the endpoints.

## Render deployment
This deployment copy is configured for Render with:

- `server.port=${PORT:8080}` in `src/main/resources/application.properties`
- a Docker image build configured in `Dockerfile`
- a Render service definition in `render.yaml`

To deploy:
1. Push this folder to GitHub.
2. Create a new Web Service in Render.
3. Connect the GitHub repo.
4. Choose the Docker deployment option or use the repo's `render.yaml`.
5. Render will start the app using the provided Dockerfile.

The app uses an in-memory H2 database, which is acceptable for this lab deployment.
