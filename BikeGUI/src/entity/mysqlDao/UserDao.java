package entity.mysqlDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DAO;
import database.MySQLDriver;
import entity.User;
import log.LogManager;

/**
 *
 * @author san.dl170111
 */

public class UserDao implements DAO<User> {
	List<User> users = new ArrayList<>();
	MySQLDriver mySQLDriver = MySQLDriver.getDriverConnection();

	public UserDao() {
		
	}

	private User extractUser(ResultSet res) throws SQLException {
		User user = new User();
		int i = 0;
		user.setId(res.getInt(++i));
		user.setName(res.getNString(++i));
		user.setCard(res.getNString(++i));
		return user;
	}

	private User checkId(int id) {
		if (users.size() == 0) return null;
		for (User user: users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		users.clear();
		String query = "SELECT * From rent_bike.user";
		ResultSet res = mySQLDriver.query(query);
		try {
			while (res.next()) {
				User user = this.extractUser(res);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User getByID(int id) {
		User user = this.checkId(id);
		if (user == null) {
			String query = "SELECT DISTINCT * FROM rent_bike.user where user.id=" +id;
			LogManager.log.info(query);
			ResultSet res = mySQLDriver.query(query);
			try {
				user = this.extractUser(res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public void save(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		
	}
	
}
