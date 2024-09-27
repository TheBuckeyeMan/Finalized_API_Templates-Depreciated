package base.template.template.api.handler;

import org.springframework.cloud.function.adapter.aws.FunctionInvoker;

//Lambda Handler is essentially the main class for lambda functions. The handleRequest method within the class is the entrypoint to the lambda. 

public class LambdaHandler extends FunctionInvoker{}