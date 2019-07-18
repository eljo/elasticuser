FROM openjdk:12-alpine
MAINTAINER Johannes Holzer <johannes.holzer@gmail.com>

ENTRYPOINT ["java", "-jar", "/app/elasticuser.jar"]

ARG JAR_FILE=elasticuser-0.0.1-SNAPSHOT.jar
ADD target/${JAR_FILE} /app/elasticuser.jar