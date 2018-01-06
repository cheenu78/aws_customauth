package org.srini.awslambda.examples.generatejwt.model;

public class Request {
  
  private String username;
  private String password;
  
  public Request() {
  }
  
  public Request(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }
  public String getPassword() {
    return password;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  
}
