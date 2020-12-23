package controller;

import entity.Card;
import entity.PaymentTransaction;
import entity.Transaction;
import exception.PaymentException;
import exception.UnrecognizedException;
import subsystem.banksubsystem.InterbankSubsystem;

/**
 * Control all business of Payment transaction
 * @author Group 10
 */

public class PaymentController {

    private InterbankSubsystem interbankSubsystem;

    /**
     * init constructor
     */
    public PaymentController() {
        this.interbankSubsystem = new InterbankSubsystem();
    }

    /**
     * payment controller
     * @param transaction {@link entity.Transaction} for payment
     * @return a respond extract to {@link entity.PaymentTransaction}
     */
    public PaymentTransaction pay(Transaction transaction) {
        return interbankSubsystem.pay(Card.getInstance(), transaction.getBike().getDeposit(), "Thue xe: Bike " + transaction.getBike().getId());
    }

    /**
     * payment controller
     * @param transaction {@link entity.Transaction} for payment
     * @return a respond extract to {@link entity.PaymentTransaction}
     */
    public PaymentTransaction refund(Transaction transaction) throws PaymentException {
        if (transaction.getTotal() > transaction.getBike().getDeposit())
            throw new UnrecognizedException();
        return interbankSubsystem.refund(Card.getInstance(), transaction.getBike().getDeposit() - transaction.getTotal(), "Hoan tien xe: Bike " + transaction.getBike().getId());
    }
}
