package exception;;

/**
 *
 * @author san.dl170111
 */

public class InvalidCardException extends PaymentException {
	public InvalidCardException() {
		super("ERROR: Invalid card!");
	}
}
