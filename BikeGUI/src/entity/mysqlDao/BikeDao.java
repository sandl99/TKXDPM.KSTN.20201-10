package entity.mysqlDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DAO;
import database.MySQLDriver;
import entity.Bike;
import log.LogManager;

/**
 *Class BikeDao dung de thao tac du lieu lien quan den Bike
 */

public class BikeDao implements DAO<Bike>{
	List<Bike> bikes = new ArrayList<>();
	MySQLDriver mySQLDriver = MySQLDriver.getDriverConnection();
	
	public BikeDao() {
		
	}
	
	private Bike extractBike(ResultSet res) throws SQLException {
		Bike bike = new Bike();
		int i = 0;
		bike.setId(res.getInt(++i));
		bike.setType(res.getInt(++i));
		bike.setPin(res.getInt(++i));
//		bike.setDeposit(res.getInt(++i));
		bike.setValue(res.getInt(++i));
		bike.setDockId(res.getInt(++i));
		bike.setBarcode(res.getNString(++i));
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
	/**
	 * getAll, and then return List<Bike>
	 * 
	 * @return danh sach tat ca xe
	 */
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
	/**
	 * getByID, then return Bike
	 * @param id - id cua xe dap
	 * @return xe dap tuong ung voi id
	 */
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
	
	/**
	 * getByDockID,, then return List<Bike>
	 * @param id - id cua bai xe
	 * @return danh sach xe dap co trong bai xe ung voi id
	 */
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
	
	/**
	 * update dung de cap nhat dockId cua xe dap 
	 * @param Bike t
	 * 
	 */
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
