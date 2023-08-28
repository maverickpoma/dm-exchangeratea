FROM openjdk:17
WORKDIR /app
COPY ./target/dm-exchangeratea-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar", "h2*.jar", "-web", "-webAllowOthers", "-tcp", "-tcpAllowOthers", "-browser"]