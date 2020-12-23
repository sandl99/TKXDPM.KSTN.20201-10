package subsystem.banksubsystem;


import exception.PaymentException;
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
     * Initializes a newly created {@link subsystem.banksubsystem.interbank.InterbankSubsystemController} object so that it
     * represents an Interbank subsystem.
     */
    public InterbankSubsystem() {
//        String str = new String();
        this.ctrl = new InterbankSubsystemController();
    }

    /**
     *
     * @param card     - the credit card used for payment
     * @param amount   - the amount to pay
     * @param contents - content for transaction
     * @return  return a respond {@link PaymentTransaction PaymentTransaction}
     * @throws PaymentException PaymentException
     */
    public PaymentTransaction pay(Card card, int amount, String contents) throws PaymentException {
        PaymentTransaction transaction = ctrl.pay(card, amount, contents);
        return transaction;
    }

    /**
     *
     * @param card     - the credit card which would be refunded to
     * @param amount   - the amount to refund
     * @param contents - content for transaction
     * @return return a respond {@link PaymentTransaction PaymentTransaction}
     * @throws PaymentException PaymentException
     */
    public PaymentTransaction refund(Card card, int amount, String contents) throws PaymentException {
        PaymentTransaction transaction = ctrl.refund(card, amount, contents);
        return transaction;
    }
}
