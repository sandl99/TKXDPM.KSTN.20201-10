package entity;

/**
 * @author san.dl170111
 */
public class Bicycle extends Bike {
    public Bicycle(int id, int type, int value, int dockId, String barcode) {
        super(id, type, value, dockId, barcode);
    }

    @Override
    public String getTypeString() {
        return "Normal Bike";
    }
}
