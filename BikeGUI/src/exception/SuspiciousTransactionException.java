package exception;;

/**
 * Suspicious Transaction Exception
 * @author Group 10
 */

public class SuspiciousTransactionException extends PaymentException {
	public SuspiciousTransactionException() {
		super("ERROR: Suspicious Transaction Report!");
	}
}
