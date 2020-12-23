package entity;

/**
 * Lop Dock chua cac thao tac lien quan den thuoc tinh cua Dock
 */

public class Dock {
	private int id;
	private String name, address;
	
	public Dock() {}
	
	/**
	 * khoi dung doi tuong cua lop Dock
	 * @param id - ma bai xe
	 * @param name - ten bai xe
	 * @param address - dia chi bai xe
	 */
	public Dock(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Dock [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}
