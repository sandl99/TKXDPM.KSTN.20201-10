package subsystem.banksubsystem;


import subsystem.banksubsystem.interbank.InterbankSubsystemController;
import entity.PaymentTransaction;
import entity.Card;

/***
 * The {@code InterbankSubsystem} class is used to communicate with the
 * Interbank to make transaction.
 *
 * @author sandl
 *
 */

public class InterbankSubsystem implements InterbankInterface {

    /**
     * Represent the controller of the subsystem
     */
    private InterbankSubsystemController ctrl;

    /**
     * Initializes a newly created {@code InterbankSubsystem} object so that it
     * represents an Interbank subsystem.
     */
    public InterbankSubsystem() {
        String str = new String();
        this.ctrl = new InterbankSubsystemController();
    }

    public PaymentTransaction pay(Card card, int amount, String contents) {
        PaymentTransaction transaction = ctrl.pay(card, amount, contents);
        return transaction;
    }

    public PaymentTransaction refund(Card card, int amount, String contents) {
        PaymentTransaction transaction = ctrl.refund(card, amount, contents);
        return transaction;
    }
}
