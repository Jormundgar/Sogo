FROM maven:3.8.3-eclipse-temurin-17 AS BUILD
COPY serviceregistry /home/serviceregistry
COPY serviceregistry/pom.xml /home/serviceregistry
RUN mvn -f /home/serviceregistry/pom.xml clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
COPY --from=BUILD home/serviceregistry/target/serviceregistry-0.0.1-SNAPSHOT.jar serviceregistry.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "serviceregistry.jar"]