FROM maven:3.9-eclipse-temurin-25
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
EXPOSE 9090
CMD ["mvn", "org.springframework.boot:spring-boot-maven-plugin:run"]