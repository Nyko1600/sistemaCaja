package myException;

public class InvalidParametersException extends Exception{  

  public InvalidParametersException() {}

  public InvalidParametersException(String message)
  {
    super(message);
  }  
}
