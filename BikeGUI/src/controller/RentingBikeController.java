package controller;

import entity.*;
import exception.PaymentException;
import log.LogManager;
import subsystem.banksubsystem.InterbankSubsystem;
import subsystem.barcodesubsystem.BarcodeSubsystem;

/**
 *
 * @author san.dl170111
 */

public class RentingBikeController {
    private BarcodeSubsystem barcodeSubsystem;
    private DockInfoController dockInfoController;
    private PaymentController paymentController;
    private ReturnBikeController returnBikeController;

    private static long startTime;
    public RentingBikeController(DockInfoController dockInfoController) {
        barcodeSubsystem = new BarcodeSubsystem();
        paymentController = new PaymentController();
        this.dockInfoController = dockInfoController;
    }
    public RentingBikeController() {
        barcodeSubsystem = new BarcodeSubsystem();
        paymentController = new PaymentController();
    }

    public void setDockInfoController(int id) {
        this.dockInfoController = new DockInfoController(id);
    }

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

    public Transaction getTransaction() {
        return Transaction.getTransaction();
    }

    public void startTransaction(Transaction transaction) throws PaymentException {
//        Card card = new Card();
//        System.out.println("S");
        LogManager.log.info("Starting Transaction ...");
        PaymentTransaction paymentTransaction = paymentController.pay(transaction);
        startTime = System.currentTimeMillis();
    }

    public long getTimeUsing() {
        long t = System.currentTimeMillis();
        System.out.println(startTime + " "+ t + " " + ((t - startTime)/ 1000));
        return (t - startTime)/ 1000;
    }

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
    public Bike requestBarcode(String barcode) {
        String barcodeConverted = this.barcodeSubsystem.exchangeBarcode(barcode);
        return dockInfoController.getBikeByBarcode(barcodeConverted);
    }
    public String requestBarcodeStr(String barcode) {
        return this.barcodeSubsystem.exchangeBarcode(barcode);
//        return dockInfoController.getBikeByBarcode(barcodeConverted);
    }
}

