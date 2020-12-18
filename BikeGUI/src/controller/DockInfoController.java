package controller;

import entity.Bike;
import entity.Dock;
import entity.mysqlDao.BikeDao;

import java.util.ArrayList;
import java.util.List;

public class DockInfoController {
    Dock dock;
    List<Bike> bikes;
    BikeDao bikeDao;
    public DockInfoController(Dock dock) {
        this.dock = dock;
        bikeDao = new BikeDao();
    }

    public List<Bike> getBikes() {
        if (bikes == null) {
            bikes = bikeDao.getByDockId(dock.getId());
        }
        return bikes;
    }

    public int getNumBike() {
        if (bikes == null) {
            this.getBikes();
        }
        return bikes.size();
    }

    public List<Bike> getBikesByType(int type) {
        List<Bike> res = new ArrayList<>();
        for (Bike bike: bikes) {
            if (bike.getType() == type) res.add(bike);
        }
        return res;
    }

    public Bike getBikeByBarcode(String barcode) {
        for (Bike bike: bikes) {
            if (barcode.equals(bike.getBarcode())) return bike;
        }
        return null;
    }
    public Dock getDock() {return dock;}
}
