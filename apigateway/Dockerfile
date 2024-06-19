FROM maven:3.8.3-eclipse-temurin-17 AS BUILD
COPY apigateway /home/apigateway
COPY apigateway/pom.xml /home/apigateway
RUN mvn -f /home/apigateway/pom.xml clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
COPY --from=BUILD home/apigateway/target/apigateway-0.0.1-SNAPSHOT.jar apigateway.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "apigateway.jar"]