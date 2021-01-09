package entity;

/**
 * @author san.dl170111
 */
public class Tandem extends Bike {
    public Tandem(int id, int type, int value, int dockId, String barcode) {
        super(id, type, value, dockId, barcode);
    }

    @Override
    public String getTypeString() {
        return "Tandem Bike";
    }
}
