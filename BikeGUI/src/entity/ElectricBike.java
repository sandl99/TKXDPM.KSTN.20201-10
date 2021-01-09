package entity;

/**
 * @author san.dl170111
 */
public class ElectricBike extends Bike {
    private int pin;

    public ElectricBike(int id, int type, int value, int dockId, String barcode, int pin) {
        super(id, type, value, dockId, barcode);
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public String getTypeString() {
        return "Electric Bike";
    }
}
