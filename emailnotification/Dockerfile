FROM maven:3.8.3-eclipse-temurin-17 AS BUILD
COPY emailnotification /home/emailnotification
COPY emailnotification/pom.xml /home/emailnotification
RUN mvn -f /home/emailnotification/pom.xml clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
COPY --from=BUILD home/emailnotification/target/emailnotification-0.0.1-SNAPSHOT.jar emailnotification.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "emailnotification.jar"]