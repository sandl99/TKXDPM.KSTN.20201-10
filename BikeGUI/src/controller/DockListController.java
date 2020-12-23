package controller;

import entity.Dock;
import entity.mysqlDao.DockDao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Lop DockListController chua cac thao tac de lay danh sach bai xe
 */

public class DockListController {
    List<Dock> docks;
    DockDao dockDao;

    /**
     * khoi dung doi tuong
     */
    public DockListController() {
        this.docks = new ArrayList<>();
        this.dockDao = new DockDao();
    }

    /**
     * Get Docks, tra ve danh sach bai xe
     * @return {@link entity.Dock}
     */
    public List<Dock> getDocks() {
        if (docks.size() == 0) {
            docks = dockDao.getAll();
        }
        return docks;
    }

}
