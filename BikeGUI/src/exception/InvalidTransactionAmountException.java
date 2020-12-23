package exception;;

/**
 * Invalid Transaction Amount Exception
 * @author Group 10
 */

public class InvalidTransactionAmountException extends PaymentException {
	public InvalidTransactionAmountException() {
		super("ERROR: Invalid Transaction Amount!");
	}
}
