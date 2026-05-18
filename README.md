# PayTrack

REST API for personal finance tracking built with Java 21, Spring Boot, PostgreSQL, JPA, Flyway, Swagger, Spotless and Checkstyle.

## Status

Current branch: `category-crud`

* [x] Initial project setup
* [ ] Category CRUD
* [ ] Transaction CRUD
* [ ] Balance and statement reports
* [ ] Global error handling
* [ ] Swagger documentation
* [ ] CI pipeline
* [ ] Test hardening
* [ ] Pagination

## Stack

* Java 21
* Spring Boot 3
* Spring Web
* Spring Data JPA
* PostgreSQL
* Flyway
* Bean Validation
* Springdoc OpenAPI
* JUnit 5 / Mockito
* Maven
* Docker Compose
* Spotless
* Checkstyle

## Requirements

* Java 21
* Docker / Docker Compose
* Make

## Setup

Create the local environment file:

```bash
cp .env.example .env
```

Start PostgreSQL:

```bash
make db-up
```

Run the application:

```bash
make run
```

The API runs at:

```text
http://localhost:8080
```

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

## Environment

Use `.env.example` as reference.

```env
POSTGRES_DB=paytrackdb
POSTGRES_USER=paytrack_user
POSTGRES_PASSWORD=paytrack_password
POSTGRES_PORT=5432

SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/paytrackdb
SPRING_DATASOURCE_USERNAME=paytrack_user
SPRING_DATASOURCE_PASSWORD=paytrack_password
```

## Commands

```bash
make help          # show available commands
make setup         # create .env and start PostgreSQL
make db-up         # start PostgreSQL
make db-down       # stop containers
make db-reset      # reset PostgreSQL volume
make db-logs       # show PostgreSQL logs
make run           # run the application
make format        # apply Spotless formatting
make checkstyle    # run Checkstyle
make verify        # run Maven verification
make validate      # format and validate the project
```

## API Roadmap

### Categories

* [ ] `POST /categories`
* [ ] `GET /categories`
* [ ] `GET /categories/{id}`
* [ ] `PUT /categories/{id}`
* [ ] `DELETE /categories/{id}`

### Transactions

* [ ] `POST /transactions`
* [ ] `GET /transactions`
* [ ] `GET /transactions/{id}`
* [ ] `PUT /transactions/{id}`
* [ ] `DELETE /transactions/{id}`

### Reports

* [ ] `GET /reports/balance`
* [ ] `GET /reports/statement?startDate=YYYY-MM-DD&endDate=YYYY-MM-DD`

## Branch Plan

* [ ] `category-crud`
* [ ] `transaction-crud`
* [ ] `balance-and-statement-reports`
* [ ] `global-error-handling`
* [ ] `swagger-and-readme-documentation`
* [ ] `ci-and-engineering-hygiene`
* [ ] `test-hardening`
* [ ] `pagination`

## Delivery Checklist

* [ ] All MVP endpoints implemented
* [ ] Flyway migrations run on a clean database
* [ ] Business rules covered by unit tests
* [ ] Standard error response implemented
* [ ] Swagger documents all endpoints
* [ ] README setup works from a fresh clone
* [ ] `make validate` passes
* [ ] No secrets committed
