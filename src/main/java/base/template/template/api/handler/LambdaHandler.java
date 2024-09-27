package base.template.template.api.handler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import base.template.template.config.LambdaAppConfig;

//Lambda Handler is essentially the main class for lambda functions. The handleRequest method within the class is the entrypoint to the lambda. 

public class LambdaHandler implements RequestStreamHandler{
    private static SpringLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;
    static {
        try {
            handler = SpringLambdaContainerHandler.getAwsProxyHandler(LambdaAppConfig.class);
            // If you are using HTTP APIs with the version 2.0 of the proxy model, use the getHttpApiV2ProxyHandler
            // method: handler = SpringLambdaContainerHandler.getHttpApiV2ProxyHandler(PetStoreSpringAppConfig.class);
        } catch (ContainerInitializationException e) {
            // if we fail here. We re-throw the exception to force another cold start
            e.printStackTrace();
            throw new RuntimeException("Could not initialize Spring framework", e);
        }
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context)
            throws IOException {
        handler.proxyStream(inputStream, outputStream, context);
    }
}