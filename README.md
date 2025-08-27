## payment system
Run ./gradlew bootRun inside each service (payments-api, psp-adapter, notification).
Start infra with docker-compose up -d (Postgres + Kafka + Redis).
Call health checks:

http://localhost:8080/payments/health
http://localhost:8081/psp/health
http://localhost:8082/notify/health