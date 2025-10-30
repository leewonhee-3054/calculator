FROM eclipse-temurin:17-jre
WORKDIR /app
COPY build/libs/calculator-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]