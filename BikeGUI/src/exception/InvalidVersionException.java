package exception;;

/**
 * Invalid Version Exception
 * @author Group 10
 */

public class InvalidVersionException extends PaymentException{
	public InvalidVersionException() {
		super("ERROR: Invalid Version Information!");
	}
}
