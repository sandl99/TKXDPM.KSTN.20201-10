package subsystem.barcodesubsystem;

/**
 * An interface for Barcode subsystem
 */
public interface BarcodeInterface {
    /**
     * exchange barcode
     * @param barcode a {@link String} barcode
     * @return a {@link String} describe Bike barcode
     */
    public String exchangeBarcode(String barcode);
}
