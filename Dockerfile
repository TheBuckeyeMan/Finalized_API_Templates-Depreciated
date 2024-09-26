FROM public.ecr.aws/lambda/java:17 AS base
WORKDIR /src
COPY <Your_Jar_File> /app/
ENV LAMBDA_TASK_ROOT=/src
ENV LAMBDA_HANDLER=<Package path to Lambda Handler>::<Lambda Handler Class Name>
CMD ["<Package path to Lambda Handler>::<Lambda Handler Class Name>"]