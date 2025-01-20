package exceptions;

public class PaimonInvalidInputException extends PaimonException {
    public PaimonInvalidInputException(String message) {
        super("invalid input: " + message);
    }
}
