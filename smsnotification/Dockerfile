FROM maven:3.8.3-eclipse-temurin-17 AS BUILD
COPY smsnotification /home/smsnotification
COPY smsnotification/pom.xml /home/smsnotification
RUN mvn -f /home/smsnotification/pom.xml clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
COPY --from=BUILD home/smsnotification/target/smsnotification-0.0.1-SNAPSHOT.jar smsnotification.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "smsnotification.jar"]