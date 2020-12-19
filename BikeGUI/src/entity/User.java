package entity;

/**
 *
 * @author san.dl170111
 */

public class User {
	private int id;
	private String name;
	private String card;
	
	public User() {}

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
