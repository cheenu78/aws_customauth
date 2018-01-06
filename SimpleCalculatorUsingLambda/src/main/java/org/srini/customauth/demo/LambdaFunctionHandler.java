package org.srini.customauth.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<Request, Object> {

  @Override
  public Object handleRequest(Request input, Context context) {
    
    int a = input.getA();
    int b = input.getB();
    String function  = input.getFunction();
    
    int retVal = 0;
    
    if(function.equals("add")) {
      retVal =  add(a, b);
    } else if(function.equals("subtract")) {
      retVal =  subtract(a, b);
    } else {
      Result result = new Result();
      result.setSuccessMessage("Cannot identify method to invoke");
    }
    
    Result result = new Result();
    result.setResult(retVal);
    result.setSuccessMessage("Method invoked :"+function);
    
    return result;
  }
  
  private int add(int a, int b){
    return a + b;
  }
  
  private int subtract(int a, int b){
    return a - b;
  }
}
