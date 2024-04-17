# URL Shortener Service

This is a simple URL shortening service implemented using Java with Spring Boot.

## Functional Requirements

1. Given a URL, the service generates a shorter and unique alias for it.
2. Users can access the original URL by using the generated short link.

## Implementation Details

- The service exposes two endpoints:
  - **POST /shorten:** Accepts a JSON payload containing the original URL and returns a shortened alias for it.
  - **GET /{alias}:** Redirects the user to the original URL associated with the provided alias.
- The shortened aliases are generated randomly using UUIDs.
- A simple in-memory map is used to store the mappings between aliases and original URLs.

## Running the Application

1. Clone this repository.
2. Make sure you have Java and Maven installed on your system.
3. Navigate to the project directory in the terminal.
4. Run the following command to start the Spring Boot application:
5. The application will start running on `http://localhost:8080`.

## Using the API with Postman

1. Open Postman.
2. Create a new request with the following details:
- Request type: POST
- URL: http://localhost:8080/shorten
- Body: Raw (JSON format)
  ```
  {
      "originalUrl": "https://www.example.com"
  }
  ```
3. Send the request.
4. Copy the shortened URL from the response.
5. Use the shortened URL to access the original URL by creating a new GET request in Postman with the shortened URL.
