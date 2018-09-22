FROM gradle:4.2.1-jdk8-alpine
COPY build/libs/demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java"]
CMD ["-jar", "/app/demo-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
