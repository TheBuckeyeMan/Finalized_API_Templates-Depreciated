package base.template.template.api.handler;

import org.springframework.cloud.function.adapter.aws.FunctionInvoker;

//Lambda Handler using FunctionInvoker will invoke the nessasary functions in the application. - This is the EntryPoint to the Lambda Function


public class LambdaHandler extends FunctionInvoker{}