package entity;

/**
 * entity class
 * @author Group 10
 */

public class Dock {
	private int id;
	private String name, address;
	
	public Dock() {}

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
