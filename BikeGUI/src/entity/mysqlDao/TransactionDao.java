package entity.mysqlDao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import database.DAO;
import database.MySQLDriver;
import entity.Transaction;

public class TransactionDao implements DAO<Transaction> {
	List<Transaction> transactions = new ArrayList<>();
	MySQLDriver mySQLDriver = MySQLDriver.getDriverConnection();
	private static final Logger log = Logger.getGlobal();

	public TransactionDao() {
		
	}
	
	private Transaction extractTransaction(ResultSet res) throws SQLException {
		Transaction transaction = new Transaction();
		int i = 0;
		transaction.setId(res.getInt(++i));
		transaction.setBikeId(res.getInt(++i));
		transaction.setUserId(res.getInt(++i));
		transaction.setStatus(res.getInt(++i));
		transaction.setTotal(res.getInt(++i));
		transaction.setDate(res.getDate(++i).toString());
		transaction.setTotalTime(res.getInt(++i));
		return transaction;
	}

	private Transaction checkId(int id) {
		if (transactions.size() == 0) return null;
		for (Transaction transaction: transactions) {
			if (transaction.getId() == id) {
				return transaction;
			}
		}
		return null;
	}
	
	@Override
	public List<Transaction> getAll() {
		transactions.clear();
		String query = "SELECT * FROM rent_bike.transaction";
		log.info(query);
		ResultSet res = mySQLDriver.query(query);
		try {
			while (res.next()) {
				Transaction transaction = this.extractTransaction(res);
				transactions.add(transaction);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactions;
	}

	@Override
	public Transaction getByID(int id) {
		Transaction transaction = this.checkId(id);
		if (transaction == null) {
			String query = "SELECT DISTINCT * FROM rent_bike.transaction where transaction.id="+id;
			log.info(query);
			ResultSet res = mySQLDriver.query(query);
			try {
				transaction = this.extractTransaction(res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return transaction;
	}

	@Override
	public void save(Transaction t) {
		String insertQuery = "INSERT INTO rent_bike.transaction (bikeId, userId, status, total, date, time) VALUES ('";
		insertQuery = insertQuery + t.getBikeId() + "','" + t.getUserId() + "','" + t.getStatus() + "','" + t.getTotal() + "','" + t.getDate().toString() + "','" + t.getTotalTime() + "')";
		log.info(insertQuery);
		mySQLDriver.insert(insertQuery);
	}

	@Override
	public void update(Transaction t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Transaction t) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		System.out.println(Date.valueOf("1999-01-12").toString());
		Transaction t = new Transaction(0, 0, 1, 120, Date.valueOf("1999-01-12").toString());
		TransactionDao transactionDao = new TransactionDao();
		transactionDao.save(t);
	}
}
