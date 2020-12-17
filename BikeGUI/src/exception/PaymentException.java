package exception;

public class PaymentException extends RuntimeException {
    public PaymentException(String s) {
        super("ERROR: Something went wrong!");
    }
}
