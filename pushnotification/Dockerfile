FROM maven:3.8.3-eclipse-temurin-17 AS BUILD
COPY pushnotification /home/pushnotification
COPY pushnotification/pom.xml /home/pushnotification
RUN mvn -f /home/pushnotification/pom.xml clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
COPY --from=BUILD home/pushnotification/target/pushnotification-0.0.1-SNAPSHOT.jar pushnotification.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "pushnotification.jar"]