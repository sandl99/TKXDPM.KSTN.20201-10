package subsystem.barcodesubsystem;

import subsystem.barcodesubsystem.barcode.BarcodeController;

public class BarcodeSubsystem implements BarcodeInterface {
    private BarcodeController barcodeController;

    public BarcodeSubsystem() {
        this.barcodeController = new BarcodeController();
    }

    @Override
    public String exchangeBarcode(String barcode) {
        return this.barcodeController.exchangeBarcode(barcode);
    }
}
