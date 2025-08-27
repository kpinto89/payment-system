## payment system
Run ./gradlew bootRun inside each service (payments-api, psp-adapter, notification).
Start infra with docker-compose up -d (Postgres + Kafka + Redis).
Call health checks:

1. http://localhost:8080/payments/health
2. http://localhost:8081/psp/health
3. http://localhost:8082/notify/health