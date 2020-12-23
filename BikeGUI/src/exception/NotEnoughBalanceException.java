package exception;

/**
 * Not Enough Balance Exception
 * @author Group 10
 */

public class NotEnoughBalanceException extends PaymentException{

	public NotEnoughBalanceException() {
		super("ERROR: Not enough balance in card!");
	}

}
