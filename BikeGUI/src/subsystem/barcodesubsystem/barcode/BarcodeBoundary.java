package subsystem.barcodesubsystem.barcode;

import subsystem.banksubsystem.utils.HttpConnector;

import java.lang.Exception;

/**
 * Class provide API for query http/https
 * @author Group 10
 * @version 1.0
 */

public class BarcodeBoundary {
    /**
     * Get result from http get/post/patch
     * @param url url of server
     * @return respond data
     */
    String query(String url) {
        String respond = null;
        try {
            respond = HttpConnector.get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respond;
    }

}
