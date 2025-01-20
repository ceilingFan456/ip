package exceptions;

public class PaimonInvalidDescriptionException extends PaimonException {
    public PaimonInvalidDescriptionException(String message) {
        super("invlid description: " + message);
    }
}
