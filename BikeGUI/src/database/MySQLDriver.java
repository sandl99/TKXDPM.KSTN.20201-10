package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.JdbcConnection;

/**
 *
 * @author san.dl170111
 */

public class MySQLDriver {
	private static MySQLDriver instance;
	
	private String url;
	private String dbName;
	private String driver;
	private String username;
	private String password;
	
	public Connection connection;
	private Statement statement;
	
	private MySQLDriver() {
		this.url = "jdbc:mysql://localhost:3306/";
		this.dbName = "rent_bike";
		this.driver = "com.mysql.cj.jdbc.Driver";
		this.username = "root";
		this.password = "1201";
		
		try {
			Class.forName(driver).newInstance();
			this.connection = (Connection) DriverManager.getConnection(url+dbName, username, password);
		} catch (Exception sql){
			sql.printStackTrace();
		}
	}
	
	public static synchronized MySQLDriver getDriverConnection() {
		if (MySQLDriver.instance == null) {
				MySQLDriver.instance = new MySQLDriver();
		}
		return MySQLDriver.instance;
	}
	
	public ResultSet query(String query) {
		ResultSet res = null;
		try {
			this.statement = MySQLDriver.instance.connection.createStatement();
			res = this.statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public int insert(String insertQuery) {
		int res = -1;
		try {
			this.statement = MySQLDriver.instance.connection.createStatement();
			res = this.statement.executeUpdate(insertQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public void update(String updateQuery) {
		this.insert(updateQuery);
	}
}
