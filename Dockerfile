//FROM amazon/aws-lambda-java:11 There is a special base container for aws lambda. Check if this is what is the problem. Update app to java 11 to use. 
FROM openjdk:17-jdk
ARG JAR_FILE=./target/template-0.0.1-SNAPSHOT.jar
COPY target/template-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
