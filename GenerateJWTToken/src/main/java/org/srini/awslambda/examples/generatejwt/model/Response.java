package org.srini.awslambda.examples.generatejwt.model;

public class Response {
  
  private String token;
  
  public Response(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }


}
