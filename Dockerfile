# Dockerfile

FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/ComeAndEat.jar
COPY ${JAR_FILE} ComeAndEat.jar
ENTRYPOINT ["java","-jar","/ComeAndEat.jar"]
