package exception;;

/**
 * Internal server exception
 * @author Group 10
 */

public class InternalServerErrorException extends PaymentException {

	public InternalServerErrorException() {
		super("ERROR: Internal Server Error!");
	}

}
