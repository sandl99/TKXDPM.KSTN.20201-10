package exception;;

/**
 *
 * @author san.dl170111
 */

public class UnrecognizedException extends RuntimeException {
	public UnrecognizedException() {
		super("ERROR: Something went wrowng!");
	}
}
