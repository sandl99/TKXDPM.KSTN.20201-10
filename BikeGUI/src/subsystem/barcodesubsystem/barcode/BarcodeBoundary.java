package subsystem.barcodesubsystem.barcode;

import subsystem.banksubsystem.utils.HttpConnector;

import java.lang.Exception;

/**
 *
 * @author san.dl170111
 */

public class BarcodeBoundary {
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
