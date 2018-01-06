package org.srini.awslambda.examples.generatejwt;

import java.io.IOException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.srini.awslambda.examples.generatejwt.model.Request;
import org.srini.awslambda.examples.generatejwt.model.Response;
import com.amazonaws.services.lambda.runtime.Context;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class GenerateJWTFunctionHandlerTest {

    private static Request input;

    @BeforeClass
    public static void createInput() throws IOException {
        input = new Request("username","password");
    }

    private Context createContext() {
        TestContext ctx = new TestContext();
        ctx.setFunctionName("generateToken");
        return ctx;
    }

    @Test
    public void testGenerateJWTFunctionHandler() {
        GenerateJWTFunctionHandler handler = new GenerateJWTFunctionHandler();
        Context ctx = createContext();
        Response output = handler.handleRequest(input, ctx);

        Assert.assertNotNull(output.getToken());
    }
}
