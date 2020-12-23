package controller;

import entity.Bike;
import subsystem.barcodesubsystem.BarcodeSubsystem;

/**
 * BarcodeController class control business of exchange barcode
 * @author Group 10
 */
public class BarcodeController {
    BarcodeSubsystem barcodeSubsystem = new BarcodeSubsystem();
    DockInfoController dockInfoController;

    /**
     * Constructor
     */
    public BarcodeController() {}

    /**
     * Constructor with {@link controller.DockInfoController}
     * @param dockInfoController dockInfoController
     */
    public BarcodeController(DockInfoController dockInfoController) {
        this.dockInfoController = dockInfoController;
    }

    /**
     *
     * @param barcode a {@link String} barcode
     * @return a {@link entity.Bike} matching with barcode in this Dock
     */
    public Bike requestBarcode(String barcode) {
        String barcodeConverted = this.barcodeSubsystem.exchangeBarcode(barcode);
        return dockInfoController.getBikeByBarcode(barcodeConverted);
    }
    /**
     *
     * @param barcode a {@link String} barcode
     * @return a {@link String} describe Bike barcode
     */
    public String requestBarcodeStr(String barcode) {
        return this.barcodeSubsystem.exchangeBarcode(barcode);
//        return dockInfoController.getBikeByBarcode(barcodeConverted);
    }
}
