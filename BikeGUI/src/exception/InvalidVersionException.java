package exception;;

/**
 *
 * @author san.dl170111
 */

public class InvalidVersionException extends PaymentException{
	public InvalidVersionException() {
		super("ERROR: Invalid Version Information!");
	}
}
