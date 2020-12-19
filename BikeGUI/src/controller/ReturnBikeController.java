package controller;

import entity.Bike;
import entity.Dock;
import entity.PaymentTransaction;
import entity.Transaction;
import entity.mysqlDao.BikeDao;
import entity.mysqlDao.TransactionDao;
import exception.PaymentException;
import subsystem.banksubsystem.utils.Utils;

import java.sql.Date;

/**
 *
 * @author san.dl170111
 */

public class ReturnBikeController {
    PaymentController paymentController;
    public ReturnBikeController() {paymentController = new PaymentController();}

    public void refund(Transaction transaction, int total, Dock dock) throws PaymentException {
        transaction.setTotal(total);
        transaction.setDate(Utils.getToday());
        paymentController.refund(transaction);
        transaction.setStatus(0);
        this.makeTransactionDao(transaction, dock);
    }

    private void makeTransactionDao(Transaction transaction, Dock dock) {
        TransactionDao transactionDao = new TransactionDao();
        BikeDao bikeDao = new BikeDao();

        transaction.setBikeId(transaction.getBike().getId());
        Bike bike = transaction.getBike();

        bike.setDockId(dock.getId());
        transaction.setUserId(0);
        transactionDao.save(transaction);

        bikeDao.update(bike);
    }
}
