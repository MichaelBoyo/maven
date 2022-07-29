package africa.semicolon.trueCaller.exceptions;

public class UserExistsException extends RuntimeException{
    public UserExistsException(String message, Throwable cause){
        super(message,cause);
    }
    public UserExistsException(String message){
        super(message);
    }
    public UserExistsException(Throwable cause){
        super(cause);
    }
}
