package controller;

import controller.calculateMoney.Calculator;
import controller.calculateMoney.CalculatorNormal;
import controller.calculateTotalTime.Timer;
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

    private static Timer timer;
    private static Calculator calculator;

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
        timer = new Timer(System.currentTimeMillis());
        calculator = new Calculator(new CalculatorNormal());
    }

    /***
     *
     * @return a long number describe time using bike
     */
    public long getTimeUsing() {
        return timer.getTimeUsing();
    }

    /**
     * method calculate the total money for user
     * @param totalTime time at current for using bike
     * @return total money
     */
    public int getTotal(long totalTime) {
        return calculator.getTotal(totalTime);
    }

}

