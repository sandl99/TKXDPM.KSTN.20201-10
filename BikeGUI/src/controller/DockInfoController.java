package controller;

import entity.Bike;
import entity.Dock;
import entity.mysqlDao.BikeDao;
import entity.mysqlDao.DockDao;

import java.util.ArrayList;
import java.util.List;

/**
 * DockInfoController control business of a dock
 * @author Group 10
 */

public class DockInfoController {
    Dock dock;
    List<Bike> bikes;
    BikeDao bikeDao;

    /**
     * Constructor with a {@link entity.Dock}
     * @param dock a {@link entity.Dock}
     */
    public DockInfoController(Dock dock) {
        this.dock = dock;
        bikeDao = new BikeDao();
    }

    /**
     * Constructor with dockId
     * @param id Id of dock
     */
    public DockInfoController(int id) {
        DockDao dockDao = new DockDao();
        this.dock = dockDao.getByID(id);
        bikeDao = new BikeDao();
    }

    /**
     * get all Bikes from databases
     * @return a {@link List} of {@link entity.Bike}
     */
    public List<Bike> getBikes() {
        if (bikes == null) {
            bikes = bikeDao.getByDockId(dock.getId());
        }
        return bikes;
    }

    /**
     * get number of Bikes in the {@link entity.Dock}
     * @return an integer
     */
    public int getNumBike() {
        if (bikes == null) {
            this.getBikes();
        }
        return bikes.size();
    }

    /**
     * get all Bikes with specific type
     * @param type an integer
     * @return a {@link List} of {@link entity.Bike}
     */
    public List<Bike> getBikesByType(int type) {
        List<Bike> res = new ArrayList<>();
        for (Bike bike: bikes) {
            if (bike.getType() == type) res.add(bike);
        }
        return res;
    }

    /**
     * get Bike by barcode
     * @param barcode  a {@link String} barcode
     * @return a {@link entity.Bike} with input barcode
     */
    public Bike getBikeByBarcode(String barcode) {
        for (Bike bike: bikes) {
            if (barcode.equals(bike.getBarcode())) return bike;
        }
        return null;
    }

    /**
     * get instance dock
     * @return {@link entity.Dock}
     */
    public Dock getDock() {return dock;}
}
