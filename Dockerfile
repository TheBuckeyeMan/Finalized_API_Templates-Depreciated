#FROM amazon/aws-lambda-java:11 There is a special base container for aws lambda. Check if this is what is the problem. Update app to java 11 to use. 
FROM public.ecr.aws/lambda/java:17
COPY target/template-0.0.1-SNAPSHOT.jar app.jar
CMD ["base.template.template.api.handler.LambdaHandler::handleRequest"]