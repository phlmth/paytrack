.DEFAULT_GOAL := help

APP_NAME := paytrack
MVNW := ./mvnw

.PHONY: help
help: ## show available commands
	@grep -E '^[a-zA-Z_-]+:.*?## ' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-18s\033[0m %s\n", $$1, $$2}'

.PHONY: env
env: ## create .env from .env.example if it does not exist
	@test -f .env || cp .env.example .env
	@echo ".env ready"

.PHONY: db-up
db-up: env ## start PostgreSQL
	docker compose up -d

.PHONY: db-down
db-down: ## stop containers
	docker compose down

.PHONY: db-reset
db-reset: ## remove containers and database volumes
	docker compose down -v
	docker compose up -d

.PHONY: db-logs
db-logs: ## show PostgreSQL logs
	docker compose logs -f postgres

.PHONY: run
run: env ## run the application locally
	$(MVNW) spring-boot:run

.PHONY: clean
clean: ## clean maven build artifacts
	$(MVNW) clean

.PHONY: format
format: ## apply Spotless formatting
	$(MVNW) spotless:apply

.PHONY: format-check
format-check: ## check Spotless formatting
	$(MVNW) spotless:check

.PHONY: checkstyle
checkstyle: ## run Checkstyle validation
	$(MVNW) checkstyle:check

.PHONY: verify
verify: ## run full Maven verification
	$(MVNW) clean verify

.PHONY: validate
validate: format verify ## format and validate the project

.PHONY: setup
setup: env db-up ## frepare the local environment
	@echo "Local environment ready"
	@echo "Run: make run"