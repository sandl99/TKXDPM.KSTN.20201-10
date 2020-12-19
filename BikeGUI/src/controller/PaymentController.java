package controller;

import entity.Card;
import entity.PaymentTransaction;
import entity.Transaction;
import exception.PaymentException;
import exception.UnrecognizedException;
import subsystem.banksubsystem.InterbankSubsystem;

/**
 *
 * @author san.dl170111
 */

public class PaymentController {

    private InterbankSubsystem interbankSubsystem;
    public PaymentController() {
        this.interbankSubsystem = new InterbankSubsystem();
    }
    public PaymentTransaction pay(Transaction transaction) {
        return interbankSubsystem.pay(Card.getInstance(), transaction.getBike().getDeposit(), "Thue xe: Bike " + transaction.getBike().getId());
    }
    public PaymentTransaction refund(Transaction transaction) throws PaymentException {
        if (transaction.getTotal() > transaction.getBike().getDeposit())
            throw new UnrecognizedException();
        return interbankSubsystem.refund(Card.getInstance(), transaction.getBike().getDeposit() - transaction.getTotal(), "Hoan tien xe: Bike " + transaction.getBike().getId());
    }
}
