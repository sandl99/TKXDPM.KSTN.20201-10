package subsystem.banksubsystem.utils;

/**
 * Class provide some default configuration
 * @author Group 10
 * @version 1.0
 */

public class Config {
    public static final String baseUrl = "https://ecopark-system-api.herokuapp.com";
    public static final String resetUrl = "/api/card/reset-balance";
    public static final String transactionUrl = "/api/card/processTransaction";
    public static final String payComment = "pay";
    public static final String refundComment = "refund";
    public static final String API_VERSION = "1.0.1";

    protected static final String APPCODE = "ByZd537kLiA=";
    protected static final String SECRETKEY = "BF+psHNnAao=";
}
