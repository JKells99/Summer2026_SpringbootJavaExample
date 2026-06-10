# Campus Food Review — Spring Boot REST API

A RESTful backend API for a campus food review platform where students and staff can discover on-campus restaurants and leave reviews. Built with Java 25 and Spring Boot 4.x as both a course project and a portfolio piece.

---

## Table of Contents

- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Architecture](#architecture)
- [What's Built So Far](#whats-built-so-far)
- [Data Models](#data-models)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [Getting Started](#getting-started)
- [What's Coming Next](#whats-coming-next)

---

## Overview

Campus Food Review gives students and staff a single place to find and evaluate food options available on or near campus. Users will be able to browse restaurants tied to a specific campus, post reviews, and filter results. The backend is a REST API built to be consumed by any frontend client — a React frontend is planned as a follow-up.

This is an actively in-progress project. The Campus domain is fully wired up and working. Restaurant and Review models exist but their full service/controller/repository layers are still being built out.

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 25 |
| Framework | Spring Boot 4.0.6 |
| Data Access | Spring Data JPA + Hibernate |
| Database | MySQL |
| Build Tool | Maven |
| API Docs | Springdoc OpenAPI (Swagger UI) 2.x |
| Testing | JUnit 5, Mockito 5, Spring Boot Test |

---

## Architecture

This project uses a standard **three-layer architecture**. Every feature (Campus, Restaurant, Review) follows the same pattern — once you understand one, you understand them all.

```
HTTP Request
     │
     ▼
┌─────────────────┐
│   Controller    │  Receives the HTTP request, calls the service, returns a response
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│    Service      │  All business logic lives here — this is where decisions are made
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│   Repository    │  Talks to the database via Spring Data JPA (no SQL needed)
└────────┬────────┘
         │
         ▼
      MySQL
```

**Package structure:**

```
com.keyin.campusfoodreview
├── campus
│   ├── Campus.java               ← JPA entity (maps to the campus table)
│   ├── CampusController.java     ← REST endpoints
│   ├── CampusService.java        ← Business logic
│   └── CampusRepository.java     ← Database access (extends JpaRepository)
├── restaurant
│   └── Restaurant.java           ← Entity defined, full layer coming soon
├── review
│   └── Review.java               ← Entity defined, full layer coming soon
└── RestaurantSystem.java         ← Spring Boot entry point (@SpringBootApplication)
```

> **Why this structure?** Grouping by feature (campus, restaurant, review) instead of by layer (controllers, services, repositories) keeps related code together. When you're working on a feature, everything you need is in one folder.

---

## What's Built So Far

### Campus — fully implemented

- Full CRUD via REST endpoints
- Seed endpoint to pre-populate sample campus data
- Service and repository layers wired up with JPA
- Unit tests for service layer (Mockito)
- Controller tests with MockMvc

### Restaurant — in progress

- `Restaurant` entity defined with `@OneToMany` relationship to `Review`
- Fields: `restaurantName`, `restaurantAddress`, `restaurantPhone`, `reviews`
- Service/Controller/Repository layers not yet implemented

### Review — in progress

- `Review` entity defined with `reviewText` and `reviewDate` fields
- Service/Controller/Repository layers not yet implemented

---

## Data Models

### Campus

| Field | Type | Notes |
|---|---|---|
| `campusId` | Long | Auto-generated primary key |
| `campusName` | String | Display name (e.g. "Keyin College - St. John's") |
| `campusAddress` | String | Street address |
| `restaurants` | List\<Restaurant\> | One campus has many restaurants (`@OneToMany`) |

### Restaurant

| Field | Type | Notes |
|---|---|---|
| `id` | Long | Auto-generated primary key |
| `restaurantName` | String | Display name |
| `restaurantAddress` | String | Street address |
| `restaurantPhone` | String | Contact number |
| `reviews` | List\<Review\> | One restaurant has many reviews (`@OneToMany`) |

### Review

| Field | Type | Notes |
|---|---|---|
| `reviewId` | Long | Auto-generated primary key |
| `reviewText` | String | The written review |
| `reviewDate` | LocalDateTime | Auto-set to the time the review was created |

---

## API Endpoints

All implemented endpoints are prefixed with `/api/campus`. Once the app is running, you can also explore them interactively via Swagger UI (see [Getting Started](#getting-started)).

### Campus Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/campus/getAllCampuses` | Returns a list of all campuses |
| `GET` | `/api/campus/getCampusById/{id}` | Returns a single campus by its ID |
| `POST` | `/api/campus/add` | Creates a new campus (send JSON body) |
| `POST` | `/api/campus/seed` | Seeds the database with 5 sample Keyin campuses |
| `DELETE` | `/api/campus/delete/{id}` | Deletes a campus by ID |

**Example — add a campus:**

```bash
curl -X POST http://localhost:8080/api/campus/add \
  -H "Content-Type: application/json" \
  -d '{"campusName": "Keyin College - St. John'\''s", "campusAddress": "45 Stavanger Dr, St. John'\''s, NL"}'
```

**Example — get all campuses:**

```bash
curl http://localhost:8080/api/campus/getAllCampuses
```

---

## Testing

Tests live under `src/test/java` and mirror the main package structure.

### What's covered

| Test Class | Type | What it tests |
|---|---|---|
| `CampusServiceTest` | Unit test | Service logic in isolation — repository is mocked with Mockito |
| `CampusControllerTest` | Controller test | HTTP layer — uses `MockMvc` to simulate real requests without starting the server |

### How to run tests

```bash
mvn test
```

### Why two types of tests?

- **Service tests** (`@ExtendWith(MockitoExtension.class)`) — fast, no Spring context needed. You mock the repository and verify the service behaves correctly.
- **Controller tests** (`@WebMvcTest`) — tests the HTTP layer. Spring loads only the web slice (no database), and you mock the service. This verifies your endpoints return the right status codes and JSON shapes.

---

## Getting Started

### Prerequisites

- Java 25
- Maven 3.8+
- MySQL running locally

### 1. Clone the repo

```bash
git clone https://github.com/JKells99/Summer2026_SpringbootJavaExample.git
cd Summer2026_SpringbootJavaExample
```

### 2. Create the database

Log into MySQL and run:

```sql
CREATE DATABASE campus_food_review;
```

### 3. Configure your credentials

Open `src/main/resources/application.properties` and update:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/campus_food_review
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

> `ddl-auto=update` means Hibernate will automatically create or update tables to match your entity classes. You don't need to write any SQL schema — just run the app and the tables appear.

### 4. Build and run

```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.

### 5. Explore the API with Swagger UI

Once the app is running, open your browser and go to:

```
http://localhost:8080/swagger-ui.html
```

Swagger UI lists every endpoint, shows expected request/response shapes, and lets you make real requests directly from the browser — no Postman required.

---

## What's Coming Next

- [ ] Restaurant service, repository, and controller layers
- [ ] Review service, repository, and controller layers
- [ ] Link reviews to restaurants via endpoints
- [ ] Star ratings (1–5) on reviews
- [ ] Average rating computed per restaurant
- [ ] Search and filter restaurants by name or rating
- [ ] User model and Spring Security (JWT authentication)
- [ ] Docker + docker-compose support
- [ ] GitHub Actions CI pipeline

---

## Author

**Jordan Kelloway** — built as part of the Keyin College Software Development program and as a portfolio project.
