FROM maven:3.6.3-jdk-11 AS MAVEN_BUILD
WORKDIR '/app'
COPY ./ ./
RUN mvn clean package
CMD ["java", "-jar", "/app/target/api-0.0.1-SNAPSHOT.jar"]