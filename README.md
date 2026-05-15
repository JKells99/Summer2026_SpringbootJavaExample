# Campus Food Review — Spring Boot REST API

A RESTful backend API for a campus food review platform where students and staff can discover on-campus restaurants, leave star-rated reviews, and search/filter dining options. Built with Java 21 and Spring Boot 3.x as both a course project and a portfolio piece.

---

## Table of Contents

- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Architecture](#architecture)
- [Features](#features)
- [Data Models](#data-models)
- [API Documentation](#api-documentation)
- [Testing Strategy](#testing-strategy)
- [Project Board](#project-board)
- [Getting Started](#getting-started)
- [Running with Docker](#running-with-docker)
- [CI/CD](#cicd)
- [Users & Authentication](#users--authentication)

---

## Overview

Campus Food Review gives students and staff a single place to find and evaluate the food options available on or near campus. Users can browse restaurants, post honest reviews with 1–5 star ratings, and filter results by cuisine type, name, or rating — all through a clean REST API built to be consumed by any frontend client (a React frontend is planned as a follow-up).

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 3.x |
| Data Access | Spring Data JPA + Hibernate |
| Database | MySQL / MariaDB |
| Build Tool | Maven |
| API Docs | Springdoc OpenAPI (Swagger UI) |
| Containerization | Docker |
| CI/CD | GitHub Actions |
| Testing | JUnit 5, Spring Boot Test, Mockito |

---

## Architecture

The project follows a classic **three-layer architecture**:

```
HTTP Request
     │
     ▼
┌─────────────────┐
│   Controller    │  Handles HTTP, maps routes, delegates to service
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│    Service      │  Business logic, validation, orchestration
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│   Repository    │  Spring Data JPA — database interaction
└────────┬────────┘
         │
         ▼
    MySQL / MariaDB
```

**Package structure:**

```
com.keyin.campusfoodreview
├── restaurant
│   ├── Restaurant.java
│   ├── RestaurantController.java
│   ├── RestaurantService.java
│   └── RestaurantRepository.java
├── review
│   ├── Review.java
│   ├── ReviewController.java
│   ├── ReviewService.java
│   └── ReviewRepository.java
└── RestaurantSystem.java
```

---

## Features

### v1 Scope

- **Restaurant Management** — Create, read, update, and delete campus restaurant listings
- **Review Management** — Post, edit, and delete reviews tied to a specific restaurant
- **Star Ratings** — Each review includes a 1–5 numeric rating
- **Average Rating** — Each restaurant exposes a computed average from all its reviews
- **Search & Filter** — Query restaurants by name, cuisine type, or minimum rating
- **Swagger UI** — Interactive API documentation auto-generated at `/swagger-ui.html`

---

## Data Models

### Restaurant

| Field | Type | Description |
|---|---|---|
| `id` | Long | Auto-generated primary key |
| `name` | String | Display name of the restaurant |
| `cuisineType` | String | Category (e.g. Pizza, Subs, Asian) |
| `hoursOfOperation` | String | Operating hours (e.g. "Mon–Fri 8am–4pm") |
| `averageRating` | Double | Computed from all associated reviews |
| `reviews` | List\<Review\> | One-to-many relationship |

### Review

| Field | Type | Description |
|---|---|---|
| `id` | Long | Auto-generated primary key |
| `rating` | int | 1–5 star rating |
| `comment` | String | Free-text written review |
| `createdAt` | LocalDateTime | Timestamp of when the review was posted |
| `reviewerName` | String | Name or identifier of the reviewer |
| `restaurant` | Restaurant | Many-to-one relationship |

---

## API Documentation

Once the app is running, visit:

```
http://localhost:8080/swagger-ui.html
```

Swagger UI provides an interactive interface to explore and test all available endpoints directly in the browser. The OpenAPI spec is also available at:

```
http://localhost:8080/v3/api-docs
```

### Planned Endpoints (summary)

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/restaurants` | Get all restaurants (supports filter params) |
| `GET` | `/api/restaurants/{id}` | Get a single restaurant by ID |
| `POST` | `/api/restaurants` | Create a new restaurant |
| `PUT` | `/api/restaurants/{id}` | Update a restaurant |
| `DELETE` | `/api/restaurants/{id}` | Delete a restaurant |
| `GET` | `/api/restaurants/{id}/reviews` | Get all reviews for a restaurant |
| `POST` | `/api/restaurants/{id}/reviews` | Post a review on a restaurant |
| `PUT` | `/api/reviews/{id}` | Update a review |
| `DELETE` | `/api/reviews/{id}` | Delete a review |

---

## Testing Strategy

Tests live under `src/test/java` and follow the same package structure as the main source.

| Type | Tool | What it covers |
|---|---|---|
| Unit tests | JUnit 5 + Mockito | Service and repository logic in isolation — dependencies mocked |
| Integration tests | Spring Boot Test | Full request-response cycles with a live Spring context and test database |

Run all tests:

```bash
mvn test
```

Run only integration tests:

```bash
mvn test -Dgroups=integration
```

---

## Project Board

Features are tracked as individual cards on the GitHub project board. Each card represents a single deliverable feature (e.g. *"Add Review Endpoint"*, *"Implement restaurant search/filter"*). Cards move through:

**Backlog → In Progress → In Review → Done**

View the board: [GitHub Projects](../../projects)

---

## Getting Started

### Prerequisites

- Java 21
- Maven 3.8+
- MySQL or MariaDB running locally

### 1. Clone the repo

```bash
git clone https://github.com/JKells99/Summer2026_SpringbootJavaExample.git
cd Summer2026_SpringbootJavaExample
```

### 2. Configure the database

Create a database and update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/campus_food_review
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build and run

```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.

---

## Running with Docker

> Docker support coming soon.

A `Dockerfile` and `docker-compose.yml` will be added to allow the app and database to be spun up together with a single command:

```bash
docker compose up
```

---

## CI/CD

This project uses **GitHub Actions** for continuous integration. On every push and pull request to `main`, the pipeline:

1. Compiles the project with Maven
2. Runs the full test suite
3. Builds a Docker image
4. (Deployment stage — to be configured)

Pipeline config: [`.github/workflows/`](.github/workflows/)

---

## Users & Authentication

> Coming in a future release once Spring Security is integrated.

A `User` model and authentication layer will be added to support:

- User registration and login
- JWT-based stateless authentication
- Role-based access control (e.g. Admin vs. Student/Staff)
- Associating reviews with authenticated user accounts

This section will be updated with full details, endpoint specs, and setup instructions when the security layer is implemented.

---

## Author

**Jordan Kelloway** — built as part of the Keyin College Software Development program and as a portfolio project.
