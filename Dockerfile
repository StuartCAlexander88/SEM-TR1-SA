FROM openjdk:17
COPY ./target/SEM-TR1-SA-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp/app.jar
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "app.jar"]