package entity;

/**
 * entity class
 * @author Group 10
 */

public abstract class Bike {
	private int id;
	private int type;
//	private int pin;
//	private int deposit;
	private int value;
	private int dockId;
	private String barcode;
	
	public Bike() {}
	
	@Override
	public String toString() {
		return "Bike [id=" + id + ", type=" + type +  ", value=" + value
				+ ", dockId=" + dockId + ", barcode=" + barcode + "]";
	}

	public Bike(int id, int type, int value, int dockId, String barcode) {
		super();
		this.id = id;
		this.type = type;
//		this.pin = pin;
//		this.deposit = deposit;
		this.value = value;
		this.dockId = dockId;
		this.barcode = barcode;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
//	public int getPin() {
//		return pin;
//	}
//
//	public void setPin(int pin) {
//		this.pin = pin;
//	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getDockId() {
		return dockId;
	}
	
	public void setDockId(int dockId) {
		this.dockId = dockId;
	}
	
	public String getBarcode() {
		return barcode;
	}
	
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public int getDeposit() {
		return this.value * 40 / 100;
	}

	public abstract String getTypeString();
}
