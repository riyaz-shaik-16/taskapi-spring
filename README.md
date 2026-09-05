# taskapi-spring

A RESTful task management API built with Spring Boot.

## Features

- Create, view, update, and delete tasks
- Track task titles, descriptions, status, and due dates
- JSON-based HTTP API

## Requirements

- Java 17 or later
- Maven 3.8+ (or use the Maven wrapper, if included)

## Getting started

Clone the repository and start the application:

```bash
git clone <repository-url>
cd taskapi-spring
./mvnw spring-boot:run
```

On Windows, use `mvnw.cmd spring-boot:run` instead.

The API is available at `http://localhost:8080`.

## Building and testing

```bash
./mvnw clean verify
```

## API usage

The task endpoints are exposed under `/tasks`:

```http
GET    /tasks
GET    /tasks/{id}
POST   /tasks
PUT    /tasks/{id}
DELETE /tasks/{id}
```

Example request:

```bash
curl -X POST http://localhost:8080/tasks \
	-H "Content-Type: application/json" \
	-d '{"title":"Learn Spring Boot","description":"Build a task API"}'
```

