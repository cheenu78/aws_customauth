package org.srini.awslambda.examples.generatejwt;

import java.security.NoSuchAlgorithmException;
import org.srini.awslambda.examples.generatejwt.model.Request;
import org.srini.awslambda.examples.generatejwt.model.Response;
import org.srini.awslambda.examples.generatejwt.util.TokenGenerator;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nimbusds.jose.JOSEException;

public class GenerateJWTFunctionHandler implements RequestHandler<Request, Response> {

  @Override
  public Response handleRequest(Request input, Context context) {
    context.getLogger().log("Input: " + input);

    if ("username".equals(input.getUsername()) && "password".equals(input.getPassword())) {
      try {
        return getSuccessfulResponse();
      } catch (NoSuchAlgorithmException | JOSEException e) {
        throw new RuntimeException("500 Error");
      }
    } else {
      throw new RuntimeException("Error");
    }
  }

  private Response getSuccessfulResponse() throws NoSuchAlgorithmException, JOSEException {
    String token = TokenGenerator.generateToken();
    return new Response(token);
  }

}
