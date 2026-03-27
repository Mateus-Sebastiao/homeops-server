# Stage 1: Builder
FROM maven:3.9.13-eclipse-temurin-25 AS builder
WORKDIR /build

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -DskipTests --no-transfer-progress

# Stage 2: Runtime - distroless (production hardened)
FROM gcr.io/distroless/java25-debian13

WORKDIR /app

COPY --from=builder /build/target/homeops.jar ./homeops.jar

EXPOSE 8080

ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-jar", "/app/homeops.jar"]