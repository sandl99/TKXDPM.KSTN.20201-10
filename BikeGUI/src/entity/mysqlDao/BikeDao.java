package entity.mysqlDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DAO;
import database.MySQLDriver;
import entity.Bicycle;
import entity.Bike;
import entity.ElectricBike;
import entity.Tandem;
import log.LogManager;

/**
 * Mysql Bike data access object implements {@link DAO}
 * @author Group 10
 */

public class BikeDao implements DAO<Bike>{
	List<Bike> bikes = new ArrayList<>();
	MySQLDriver mySQLDriver = MySQLDriver.getDriverConnection();
	
	public BikeDao() {
		
	}
	
	private Bike extractBike(ResultSet res) throws SQLException {
		int i = 0;
		int id = res.getInt(++i);
		int type = res.getInt(++i);
		int pin = res.getInt(++i);
		int value = res.getInt(++i);
		int dockId = res.getInt(++i);
		String barcode = res.getNString(++i);

		Bike bike = null;
		if (type == 0) {
			bike = new Bicycle(id, type, value, dockId, barcode);
		} else if (type == 1) {
			bike = new ElectricBike(id, type, value, dockId, barcode, pin);
			((ElectricBike) bike).setPin(res.getInt(++i));
		} else if (type == 2) {
			bike = new Tandem(id, type, value, dockId, barcode);
		}
		return bike;
	}
	
	private Bike checkBarcode(String barcode) {
		if (bikes.size() == 0) return null;
		for (Bike bike: bikes) {
			if (bike.getBarcode().equals(barcode)) return bike;
		}
		return null;
	}
	
	private Bike checkId(int id) {
		if (bikes.size() == 0) return null;
		for (Bike bike: bikes) {
			if (bike.getId() == id) return bike;
		}
		return null;
	}
	
	@Override
	public List<Bike> getAll() {
		bikes.clear();
		String query = "SELECT * FROM rent_bike.bike";
		LogManager.log.info(query);
		ResultSet res = mySQLDriver.query("SELECT * FROM rent_bike.bike");
		try {
			while (res.next()) {
				Bike bike = this.extractBike(res);
				System.out.println(bike.toString());
				bikes.add(bike);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.bikes;
	}

	@Override
	public Bike getByID(int id) {
		// TODO Auto-generated method stub
		Bike bike = this.checkId(id);
		if (bike == null) {
			String query = "SELECT DISTINCT * FROM rent_bike.bike where bike.id=" + id;
			LogManager.log.info(query);
			ResultSet res = mySQLDriver.query("SELECT DISTINCT * FROM rent_bike.bike where bike.id=" + id);
			try {
				bike = this.extractBike(res);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bike;
	}

	public List<Bike> getByDockId(int id) {
		List<Bike> _bikes = new ArrayList<>();
		String query = "SELECT * FROM rent_bike.bike WHERE bike.dockId=" + id;
		LogManager.log.info(query);
		ResultSet res = mySQLDriver.query(query);
		try {
			while (res.next()) {
				Bike bike = this.extractBike(res);
				_bikes.add(bike);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return _bikes;
	}

	@Override
	public void save(Bike t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Bike t) {
		String query = "UPDATE `rent_bike`.`bike` SET `dockId` = '" + t.getDockId() + "' WHERE (`id` = '" + t.getId() + "')";
		LogManager.log.info(query);
		mySQLDriver.update(query);
	}

	@Override
	public void delete(Bike t) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
//		BikeDao bikeDao = new BikeDao();
//		bikeDao.getAll();
//		System.out.print(bikeDao.getByID(0).toString());
		DockDao dockDao = new DockDao();
		dockDao.getAll();
	}

}
