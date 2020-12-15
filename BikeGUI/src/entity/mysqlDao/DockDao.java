package entity.mysqlDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DAO;
import database.MySQLDriver;
import entity.Dock;
import log.LogManager;

public class DockDao implements DAO<Dock> {
	List<Dock> docks = new ArrayList<>();
	MySQLDriver mySQLDriver = MySQLDriver.getDriverConnection();

	public DockDao() {
		
	}
	
	private Dock extractDock(ResultSet res) throws SQLException {
		Dock dock = new Dock();
		int i = 0;
		dock.setId(res.getInt(++i));
		dock.setName(res.getNString(++i));
		dock.setAddress(res.getNString(++i));
		return dock;
	}
	
	private Dock checkId(int id) {
		if (docks.size() == 0) return null;
		for (Dock dock: docks) {
			if (dock.getId() == id) return dock;
		}
		return null;
	}
	
	@Override
	public List<Dock> getAll() {
		docks.clear();
		String query = "SELECT * FROM rent_bike.dock";
		LogManager.log.info(query);
		ResultSet res = mySQLDriver.query("SELECT * FROM rent_bike.dock");
		try {
			while (res.next()) {
				Dock dock = this.extractDock(res);
				System.out.println(dock.toString());
				docks.add(dock);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Dock getByID(int id) {
		Dock dock = this.checkId(id);
		if (dock == null) {
			String query = "SELECT DISTINCT * FROM rent_bike.dock WHERE dock.id=" + id;
			LogManager.log.info(query);
			ResultSet res = mySQLDriver.query("SELECT DISTINCT * FROM rent_bike.dock WHERE dock.id=" + id);
			try {
				dock = this.extractDock(res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void save(Dock t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Dock t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Dock t) {
		// TODO Auto-generated method stub
		
	}
	
}
