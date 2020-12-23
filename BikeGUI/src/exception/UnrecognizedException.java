package exception;;

/**
 * Unrecognized Exception
 * @author Group 10
 */

public class UnrecognizedException extends RuntimeException {
	public UnrecognizedException() {
		super("ERROR: Something went wrowng!");
	}
}
