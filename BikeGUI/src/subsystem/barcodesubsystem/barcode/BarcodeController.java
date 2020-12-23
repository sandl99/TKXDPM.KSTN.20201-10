package subsystem.barcodesubsystem.barcode;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Class implement API for exchange Barcode subsystem
 * @author Group 10
 * @version 1.0
 */

public class BarcodeController {
    /**
     * API instances for Barcode Controller
     */
    BarcodeBoundary barcodeBoundary = new BarcodeBoundary();

    /**
     * exchange Barcode by using query http to server
     * @param barcode a {@link String} barcode
     * @return a {@link String} describe Bike barcode
     */
    public String exchangeBarcode(String barcode) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("b", barcode);
        String respond = barcodeBoundary.query("https://barcode-lamsan.herokuapp.com/barcode/?b=" + barcode);
        System.out.println(respond);
        JsonObject respondJson = new JsonParser().parse(respond).getAsJsonObject();
        return respondJson.get("barcode").getAsString();
    }

    public static void main(String[] args) {
        BarcodeController barcodeController = new BarcodeController();
        barcodeController.exchangeBarcode("san");
    }
}
