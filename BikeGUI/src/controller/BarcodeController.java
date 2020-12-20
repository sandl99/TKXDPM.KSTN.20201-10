package controller;

import entity.Bike;
import sample.BarcodeBoundary;
import subsystem.barcodesubsystem.BarcodeSubsystem;

/**
 * @author san.dl170111
 */
public class BarcodeController {
    BarcodeSubsystem barcodeSubsystem = new BarcodeSubsystem();
    DockInfoController dockInfoController;

    public BarcodeController() {}

    public BarcodeController(DockInfoController dockInfoController) {
        this.dockInfoController = dockInfoController;
    }
    public Bike requestBarcode(String barcode) {
        String barcodeConverted = this.barcodeSubsystem.exchangeBarcode(barcode);
        return dockInfoController.getBikeByBarcode(barcodeConverted);
    }
    public String requestBarcodeStr(String barcode) {
        return this.barcodeSubsystem.exchangeBarcode(barcode);
//        return dockInfoController.getBikeByBarcode(barcodeConverted);
    }
}
