package controller;

import entity.Bike;
import entity.Dock;
import entity.mysqlDao.BikeDao;
import entity.mysqlDao.DockDao;

import java.util.ArrayList;
import java.util.List;


/**
 * Lop DockInfoController cung cap cac thao tac de lay thong tin cua bai xe
 */
public class DockInfoController {
    Dock dock;
    List<Bike> bikes;
    BikeDao bikeDao;
    
    /**
     * DockInfoController dung de khoi dung doi tuong
     * 
     * @param dock 
     */
    public DockInfoController(Dock dock) {
        this.dock = dock;
        bikeDao = new BikeDao();
    }
    
   
    public DockInfoController(int id) {
        DockDao dockDao = new DockDao();
        this.dock = dockDao.getByID(id);
        bikeDao = new BikeDao();
    }
    
    /**
     * Get Bikes, tra ve danh sach xe trong bai
     * 
     * @return {@link 
     */
    public List<Bike> getBikes() {
        if (bikes == null) {
            bikes = bikeDao.getByDockId(dock.getId());
        }
        return bikes;
    }
    
    /**
     * getNumBike
     * @return so luong xe trong bai
     */
    public int getNumBike() {
        if (bikes == null) {
            this.getBikes();
        }
        return bikes.size();
    }
    
    /**
     * getBikesByType
     * @param type - loai xe 
     * @return danh sach xe theo loai xe trong bai
     */
    public List<Bike> getBikesByType(int type) {
        List<Bike> res = new ArrayList<>();
        for (Bike bike: bikes) {
            if (bike.getType() == type) res.add(bike);
        }
        return res;
    }
    
    /**
     * getBikeByBarcode
     * @param barcode - barcode cua xe
     * @return xe tuong ung voi Barcode
     */
    public Bike getBikeByBarcode(String barcode) {
        for (Bike bike: bikes) {
            if (barcode.equals(bike.getBarcode())) return bike;
        }
        return null;
    }
    
    /**
     * getDock
     * @return bai xe
     */
    public Dock getDock() {return dock;}
}
