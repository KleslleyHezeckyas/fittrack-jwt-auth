# FitTrack – Training Management Platform

FitTrack is a Spring Boot 3 application focused on secure authentication, user session control, and dashboard access using JWT, Spring Security, and JPA/Hibernate. The project serves as a foundation for a fitness training management platform and demonstrates modern backend practices used in real-world systems.

---

## Core Technologies

### Spring Boot 3
Framework used to simplify backend development, reduce boilerplate configuration, and provide a production-ready application structure.

### JWT (JSON Web Token)
Authentication mechanism where a token is generated after login and used to validate the user session without storing state on the server.

### Spring Security
Security layer responsible for authentication, authorization, and access control. It validates credentials, reads JWT tokens, and protects restricted routes and resources.

### Thymeleaf + Tailwind CSS
Thymeleaf renders server-side HTML pages, while Tailwind CSS provides a clean, responsive, and maintainable UI layer for the dashboard.

### JPA / Hibernate
Persistence layer that maps Java entities to database tables, reducing manual SQL usage and improving consistency and maintainability.

### H2 Database (Development Mode)
Lightweight in-memory database used during development. Tables and data are created when the application starts.

### Swagger / OpenAPI
Interactive API documentation that lists available endpoints and facilitates integration with external applications or clients.

---

## Authentication Flow

1. The user submits login credentials.
2. Spring Security validates the credentials through JPA and the database.
3. If authentication is successful, a JWT token is generated.
4. The token is returned to the client.
5. The token is sent in subsequent requests for authorization.
6. The dashboard is accessible only to authenticated users.

---

## Project Goals

- Implement secure authentication using JWT
- Apply Spring Security best practices
- Use JPA/Hibernate for data persistence abstraction
- Provide API documentation with Swagger/OpenAPI
- Maintain a clean and scalable backend architecture
- Serve as a portfolio-ready Spring Boot project

---

## Environment

Runtime: Spring Boot 3  
Persistence: JPA / Hibernate  
Database: H2 (in-memory, development mode)  
Security: Spring Security + JWT  
UI Layer: Thymeleaf + Tailwind CSS  

---

## Status

Environment: Development  
Purpose: Training management platform foundation and authentication workflow demonstration

---

## Next Improvements (Roadmap)

- Replace H2 with PostgreSQL in production profile
- Add user roles and permission levels
- Create training plan entities and dashboard features
- Expose REST endpoints for external integrations
- Add unit and integration tests

---

## Running the Project

1. Clone the repository  
2. Configure environment variables (database and security)  
3. Run the Spring Boot application  
4. Access the dashboard and authentication flow

The project is structured to support future expansion into a complete fitness training management system.

