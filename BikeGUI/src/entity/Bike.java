package entity;

/**
 *
 * Lop Bike chua cac thao tac lien quan den cac thuoc tinh cua Bike
 */

public class Bike {
	private int id;
	private int type;
	private int pin;
//	private int deposit;
	private int value;
	private int dockId;
	private String barcode;
	
	public Bike() {}
	
	@Override
	public String toString() {
		return "Bike [id=" + id + ", type=" + type + ", pin=" + pin  + ", value=" + value
				+ ", dockId=" + dockId + ", barcode=" + barcode + "]";
	}
	
	/**
	 * khoi dung doi tuong
	 * @param id - id cua Bike
	 * @param type - loai xe
	 * @param pin - dung luong pin
	 * @param value - gia xe
	 * @param dockId - ma bai xe chua chiec xe
	 * @param barcode - barcode cua xe
	 */
	public Bike(int id, int type, int pin, int value, int dockId, String barcode) {
		super();
		this.id = id;
		this.type = type;
		this.pin = pin;
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
	
	public int getPin() {
		return pin;
	}
	
	public void setPin(int pin) {
		this.pin = pin;
	}
	
//	public int getDeposit() {
//		return deposit;
//	}
//
//	public void setDeposit(int deposit) {
//		this.deposit = deposit;
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
	
	/**
	 * getTypeString, tra ve loai xe
	 */
	public String getTypeString() {
		if (this.getType() == 0)
			return "Normal Bike";
		else if (this.getType() == 1)
			return "Electric Bike";
		else
			return "Tandem Bike";
	}
}
