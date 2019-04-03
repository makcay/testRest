FROM alpine/git as clone
WORKDIR /app
RUN git clone https://github.com/makcay/testRest.git

FROM maven:3.5-jdk-8-alpine as build
WORKDIR /app
COPY --from=clone /app/testRest /app
RUN ["mvn", "compile"]
RUN ["mvn", "verify"]
RUN ["mvn", "package"]

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/target/testRest-1.0.jar /app
COPY --from=build /app/files /app/files
CMD ["java","-jar","testRest-1.0.jar"]
