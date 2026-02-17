# E-Commerce Product Management API

This project is a RESTful API implementation for managing e-commerce products, developed as part of an academic assignment for Web Technologies. It demonstrates the fundamental concepts of building microservices using Spring Boot, prioritizing clear structure and beginner-friendly implementation patterns.

## Project Overview

The primary goal of this project is to implement a complete CRUD (Create, Read, Update, Delete) system for managing product data. The application is built using a layered architecture to separate concerns and make the codebase easy to understand and maintain.

### Key Features
- **Create**: Add new products to the inventory.
- **Read**: Retrieve product details by ID or list all available products.
- **Update**: Modify existing product information.
- **Delete**: Remove products from the system.

## Technology Stack

- **Java Development Kit (JDK)**: Version 21
- **Framework**: Spring Boot 4.0.2
- **Build Tool**: Maven
- **Database**: PostgreSQL
- **Persistence**: Spring Data JPA (Hibernate)

## Architecture

The project follows a standard 3-tier architecture:

1.  **Controller Layer (`auca.ac.rw.restfullApiAssignment.controller`)**:
    -   Handles incoming HTTP requests.
    -   Maps endpoints to service methods.
    -   Returns appropriate HTTP responses (e.g., 200 OK, 404 Not Found).

2.  **Service Layer (`auca.ac.rw.restfullApiAssignment.service`)**:
    -   Contains the business logic.
    -   Validates data (e.g., checking if a product exists before updating).
    -   Communicates with the repository.

3.  **Repository Layer (`auca.ac.rw.restfullApiAssignment.repository`)**:
    -   Interfaces with the database.
    -   Extends `JpaRepository` for built-in database operations.

4.  **Model Layer (`auca.ac.rw.restfullApiAssignment.modal.ecommerce`)**:
    -   Defines the data structure (`Product` entity) mapped to the database table.

## API Endpoints

The API is exposed under the base path `/api/products`.

| Method | Endpoint | Description | Request Body |
| :--- | :--- | :--- | :--- |
| **POST** | `/addProduct` | Create a new product | JSON Object (Product) |
| **GET** | `/getAllProducts` | Retrieve all products | None |
| **GET** | `/searchById` | Find a product by ID | JSON Object `{"id": <id>}` |
| **PUT** | `/updateProduct` | Update an existing product | JSON Object (Product) |
| **DELETE** | `/deleteProduct` | Remove a product | JSON Object `{"id": <id>}` |

### JSON Request Body Example (Product)
```json
{
  "id": 1,
  "name": "Smartphone",
  "description": "Latest model with high-res camera",
  "price": 699.99,
  "category": "Electronics",
  "stockQuantity": 50,
  "brand": "TechBrand"
}
```

## Configuration

The application is configured to connect to a PostgreSQL database named `ecommerce_db`.

### `application.properties` Highlights
-   **Database URL**: `jdbc:postgresql://localhost:5432/ecommerce_db`
-   **DDL Auto**: `create`
    -   *Note*: This setting automatically creates the database schema on startup. **Warning**: It effectively resets the database every time the application restarts, which is suitable for development and testing but not for production.

## Getting Started

1.  **Prerequisites**:
    -   Ensure Java 21 is installed.
    -   Ensure PostgreSQL is installed and running on port 5432.
    -   Create a database named `ecommerce_db` in PostgreSQL.

2.  **Running the Application**:
    -   Open the project in your IDE or terminal.
    -   Run the command:
        ```bash
        ./mvnw spring-boot:run
        ```
    -   The application will start on port 8080 (default).

3.  **Testing**:
    -   Use tools like Postman or simple `curl` commands to test the endpoints listed above.

## Academic Context

This implementation focuses on educational clarity:
-   **Explicit Logic**: Service methods use clear implementations to show the flow of checking for existence before performing actions.
-   **Standard Naming**: Class and method names follow Java conventions for readability.
-   **Layered Separation**: Distinct packages for Controller, Service, and Repository enforce separation of concerns, a key software engineering principle.
