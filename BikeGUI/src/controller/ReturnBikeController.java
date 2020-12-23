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
 * Class control business of returning bike
 * @author Group 10
 */

public class ReturnBikeController {
    PaymentController paymentController;

    /**
     * Constructor
     */
    public ReturnBikeController() {paymentController = new PaymentController();}

    /**
     * refund money after returning bike
     * @param transaction an Singleton transaction
     * @param total total money
     * @param dock {@link entity.Dock} user want to return
     * @throws PaymentException PaymentException
     */
    public void refund(Transaction transaction, int total, Dock dock) throws PaymentException {
        transaction.setTotal(total);
        transaction.setDate(Utils.getToday());
        paymentController.refund(transaction);
        transaction.setStatus(0);
        this.makeTransactionDao(transaction, dock);
    }

    /**
     * completing some business such as saving to databases, reset {@link Transaction}, ...
     * @param transaction an Singleton transaction
     * @param dock {@link entity.Dock} user want to return
     */
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
