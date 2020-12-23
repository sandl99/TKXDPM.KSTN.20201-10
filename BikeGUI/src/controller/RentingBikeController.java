package controller;

import entity.*;
import exception.PaymentException;
import log.LogManager;
import subsystem.banksubsystem.InterbankSubsystem;
import subsystem.barcodesubsystem.BarcodeSubsystem;

/**
 * Class control returning business
 * @author Group 10
 */

public class RentingBikeController {
    private BarcodeSubsystem barcodeSubsystem;
    private DockInfoController dockInfoController;
    private PaymentController paymentController;
    private ReturnBikeController returnBikeController;

    private static long startTime;

    /**
     * Constructor with {@link controller.DockInfoController}
     * @param dockInfoController - {@link controller.DockInfoController}
     */
    public RentingBikeController(DockInfoController dockInfoController) {
        barcodeSubsystem = new BarcodeSubsystem();
        paymentController = new PaymentController();
        this.dockInfoController = dockInfoController;
    }

    /**
     * Default constructor
     */
    public RentingBikeController() {
        barcodeSubsystem = new BarcodeSubsystem();
        paymentController = new PaymentController();
    }

    /**
     * set {@link DockInfoController} for this object by dockId
     * @param id - an Integer of dockId
     */
    public void setDockInfoController(int id) {
        this.dockInfoController = new DockInfoController(id);
    }

    /**
     * initialize {@link Transaction} for new Transaction
     * @param transaction an Singleton transaction
     * @param name name of User
     * @param card a Singleton object {@link entity.Card}
     * @param bike a {@link entity.Bike} which user want to rent
     * @return a {@link Transaction}
     */
    public Transaction setTransaction(Transaction transaction, String name, String card, Bike bike) {
        if (transaction.getStatus() == 0) {
            User user = new User();
            user.setName(name);
            user.setCard(card);

            transaction.setBike(bike);
            transaction.setUser(user);
            transaction.setStatus(1);
        }
        return transaction;
    }

    /**
     * get Transaction
     * @return a {@link Transaction}
     */
    public Transaction getTransaction() {
        return Transaction.getTransaction();
    }

    /***
     * start counting time for renting.
     * @param transaction a Singleton object {@link entity.Transaction}
     * @throws PaymentException -- throw PaymentTransaction
     */
    public void startTransaction(Transaction transaction) throws PaymentException {
//        Card card = new Card();
//        System.out.println("S");
        LogManager.log.info("Starting Transaction ...");
        PaymentTransaction paymentTransaction = paymentController.pay(transaction);
        startTime = System.currentTimeMillis();
    }

    /***
     *
     * @return a long number describe time using bike
     */
    public long getTimeUsing() {
        long t = System.currentTimeMillis();
        System.out.println(startTime + " "+ t + " " + ((t - startTime)/ 1000));
        return (t - startTime)/ 1000;
    }

    /**
     * method calculate the total money for user
     * @return total money
     */
    public int getTotal() {
        long t = getTimeUsing();
//        long t = 1801;
        this.getTransaction().setTotalTime((int) t);
//        long t = 2100;
        if (t <= 600) {
            return 0;
        } else if (t <= 900) {
            return 10000;
        }
        t /= 60;
        double numT = ((double) t) / 15;
        return 10000 + 3000 * ((int)Math.ceil(numT));
    }

}

