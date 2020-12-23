package entity;

/**
 *Lop User chua cac thao tac lien quan den thuoc tinh cua User
 */

public class User {
	private int id;
	private String name;
	private String card;
	
	public User() {}
	
	/**
	 * khoi dung doi tuong cua lop User
	 * @param id - ma khach hang
	 * @param name - ten
	 * @param card - ma the
	 */
	public User(int id, String name, String card) {
		super();
		this.id = id;
		this.name = name;
		this.card = card;
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

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}
	
	
}
