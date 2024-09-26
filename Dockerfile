FROM public.ecr.aws/lambda/java:17 AS base
WORKDIR /app

# Copy your built JAR file into the container
COPY target/template-0.0.1-SNAPSHOT.jar /app/

# Set up the necessary environment variables for Lambda to find the handler
ENV LAMBDA_TASK_ROOT=/app
ENV LAMBDA_HANDLER=base.template.template.api.handler.LambdaHandler::handleRequest

# Set the correct CMD to launch your Lambda Handler
CMD ["base.template.template.api.handler.LambdaHandler::handleRequest"]
