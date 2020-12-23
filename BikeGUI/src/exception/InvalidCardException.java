package exception;;

/**
 * Invalid Card Exception
 * @author Group 10
 */

public class InvalidCardException extends PaymentException {
	public InvalidCardException() {
		super("ERROR: Invalid card!");
	}
}
