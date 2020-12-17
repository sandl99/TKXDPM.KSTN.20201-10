package entity;

import java.sql.Date;

public class Transaction {
	private int userId;
	private int bikeId;
	private int id;
	private int status;
	private int total;
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Transaction() {}
	
	@Override
	public String toString() {
		return "Transaction [userId=" + userId + ", bikeId=" + bikeId + ", id=" + id + ", status=" + status + ", total="
				+ total + "]";
	}

	public Transaction(int userId, int bikeId, int id, int status, int total, Date date) {
		super();
		this.userId = userId;
		this.bikeId = bikeId;
		this.id = id;
		this.status = status;
		this.total = total;
		this.date = date;
	}

	public Transaction(int bikeId, int id, int status, int total, Date date) {
		super();
		this.userId = userId;
		this.bikeId = bikeId;
//		this.id = id;
		this.status = status;
		this.total = total;
		this.date = date;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBikeId() {
		return bikeId;
	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
}
