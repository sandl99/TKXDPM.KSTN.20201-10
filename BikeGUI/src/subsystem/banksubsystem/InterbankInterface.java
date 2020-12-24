package subsystem.banksubsystem;

import entity.PaymentTransaction;
import entity.Card;

/**
 * The {@code InterbankInterface} class is used to communicate with the
 *
 *
 * @author san.dl
 *
 */
public interface InterbankInterface {
    /**
     * Pay order, and then return the payment transaction
     *
     * @param card     - the credit card used for payment
     * @param amount   - the amount to pay
     * @param content - the transaction contents
     * @return {@link entity.PaymentTransaction PaymentTransaction} - if the
     *         payment is successful
     */
    public abstract PaymentTransaction pay(Card card, int amount, String content);

    /**
     * Refund, and then return the payment transaction
     *
     * @param card     - the credit card which would be refunded to
     * @param amount   - the amount to refund
     * @param content - the transaction contents
     * @return {@link entity.PaymentTransaction PaymentTransaction} - if the
     *         payment is successful
     */
    public abstract PaymentTransaction refund(Card card, int amount, String content);
}
