FROM public.ecr.aws/lambda/java:17 AS base
WORKDIR /app
COPY target/template-0.0.1-SNAPSHOT.jar /app/
ENV LAMBDA_TASK_ROOT=/app
ENV LAMBDA_HANDLER=base.template.template.api.handler.LambdaHandler::handleRequest
CMD ["/bin/sh"]