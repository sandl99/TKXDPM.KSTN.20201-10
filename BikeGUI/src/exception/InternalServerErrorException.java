package exception;;

/**
 *
 * @author san.dl170111
 */

public class InternalServerErrorException extends PaymentException {

	public InternalServerErrorException() {
		super("ERROR: Internal Server Error!");
	}

}
