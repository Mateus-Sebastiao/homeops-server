FROM gcr.io/distroless/java25-debian13

WORKDIR /app

COPY target/*.jar ./homeops.jar

EXPOSE 8080

ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-jar", "/app/homeops.jar"]