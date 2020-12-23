package subsystem.banksubsystem.interbank;

import subsystem.banksubsystem.utils.HttpConnector;

import java.io.IOException;

/**
 * Class provide API for query http/https
 * @author Group 10
 * @version 1.0
 */

public class InterbankBoundary {
    /**
     * Get result from http get/post/patch
     * @param url url of server
     * @param data query or a json data
     * @return respond data
     */
    String query(String url, String data) {
        String respond = null;
        try {
            respond = HttpConnector.post(url, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respond;
    }
}
