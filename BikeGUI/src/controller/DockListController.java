package controller;

import entity.Dock;
import entity.mysqlDao.DockDao;

import java.util.ArrayList;
import java.util.List;

/**
 *  DockListController control business of Dock List
 * @author Group 10
 */

public class DockListController {
    List<Dock> docks;
    DockDao dockDao;

    /**
     * init constructor
     */
    public DockListController() {
        this.docks = new ArrayList<>();
        this.dockDao = new DockDao();
    }

    /**
     * get all docks
     * @return a {@link List} of {@link entity.Dock}
     */
    public List<Dock> getDocks() {
        if (docks.size() == 0) {
            docks = dockDao.getAll();
        }
        return docks;
    }

}
