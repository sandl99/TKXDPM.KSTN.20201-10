package subsystem.banksubsystem.interbank;

import subsystem.banksubsystem.utils.HttpConnector;

import java.io.IOException;

/**
 *
 * @author san.dl170111
 */

public class InterbankBoundary {
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
