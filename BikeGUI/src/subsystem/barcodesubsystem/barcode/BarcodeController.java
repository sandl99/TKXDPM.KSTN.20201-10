package subsystem.barcodesubsystem.barcode;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author san.dl170111
 */

public class BarcodeController {
    BarcodeBoundary barcodeBoundary = new BarcodeBoundary();
    public String exchangeBarcode(String barcode) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("b", barcode);
        String respond = barcodeBoundary.query("http://localhost:3000/barcode/?b=" + barcode);
        System.out.println(respond);
        JsonObject respondJson = new JsonParser().parse(respond).getAsJsonObject();
        return respondJson.get("barcode").getAsString();
    }

    public static void main(String[] args) {
        BarcodeController barcodeController = new BarcodeController();
        barcodeController.exchangeBarcode("san");
    }
}
