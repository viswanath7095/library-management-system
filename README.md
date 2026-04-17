# Library Management System

A Spring Boot backend project with:

- CRUD operations
- Pagination, Search, Filtering
- DTO architecture
- Validation & Exception Handling
- API Response Wrapper
- Swagger UI integration

## Tech Stack
- Java
- Spring Boot
- MySQL
- JPA/Hibernate

## Run
1. Clone the repo
2. Configure DB in application.properties
3. Run the application

## API Docs (Swagger)
http://localhost:8082/swagger-ui/index.html

## Features

- Add, update, delete books
- Search books by title
- Filter books by author and status
- Pagination support
- DTO-based API design
- Validation using annotations
- Global exception handling
- Standard API response wrapper

## API Endpoints

| Method | Endpoint        | Description         |
|--------|---------------|---------------------|
| GET    | /books        | Get all books       |
| POST   | /books        | Add book            |
| PUT    | /books/{id}   | Update book         |
| PATCH  | /books/{id}   | Update status       |
| DELETE | /books/{id}   | Delete book         |
| GET    | /books/search | Search books        |
| GET    | /books/filter | Filter books        |

## Example Response

```json
{
  "success": true,
  "message": "Books fetched successfully",
  "data": []
}
## API Preview

![Swagger UI](swagger.png)
