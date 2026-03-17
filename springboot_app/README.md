# HomeOps Platform - Cloud Native Java Core

This is a simple SpringBoot Application with Thymeleaf UI integration that demonstrates CRUD operations on PostgreSQL database.

## Tools and Technical Decisions

- Java 25 (latest LTS candidate) + Maven multi-stage build
- Distroless Java 25 (`gcr.io/distroless/java25-debian13`) - no shell, no package manager, minimal attack surface
- Non-root user (`nonroot`) + container-aware JVM flags (`UseContainerSupport` + `MaxRAMPercentage=75.0`)
- Trivy scan: **0 critical on OS layer** (distroless)
- Java dependencies: **8 critical** (typical transitive CVEs in Spring Boot ecosystem - remediation via Dependabot/Renovate coming)

## Running the Application

Run the application by simply executing the below command from the directory where docker-compose.yaml file is located.

```bash
git clone https://github.com/Mateus-Sebastiao/homeops-server
cd homeops-server/springboot_app

docker compose up --build
```

Access the application on http://127.0.0.1:8080

## Build Docker Image for Scanning


```bash
docker build -t REGISTRY/YOUR_USERNAME/springboot_app-springboot:latest -f Dockerfile
docker push REGISTRY/YOUR_USERNAME/springboot_app-springboot:latest
```

## Scan Security Vulnerability

```bash
docker run -v /var/run/docker.sock:/var/run/docker.sock -v $HOME/Library/Caches:/root/.cache/ aquasec/trivy:0.69.3 image --timeout 30m REGISTRY/YOUR_USERNAME/springboot_app-springboot:latest
```
- OS: **0 critical** (distroless)
- Java Dependencies: **8 critical** (Dependabot + Renovate can solve it)

## Original Source Code Reference

https://github.com/devnakka/Spring-Boot-Email-Thymeleaf

## Original Source Code

https://github.com/Apress/Practical-GitOps

## Contribute

Open to discussions on Cloud Native, DevSecOps, HomeOps setups, Java in production, Docker hardening, observability - anything in this space.
Drop a comment, star if it helps, or reach out on LinkedIn / X.