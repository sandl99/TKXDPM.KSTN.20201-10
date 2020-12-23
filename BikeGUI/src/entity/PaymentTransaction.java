package entity;


public class PaymentTransaction {
    private String errorCode;
    private Card card;
    private String transactionId;
    private String transactionContent;
    private int amount;
    private String createdAt;
    
    /**
     * khoi dung doi tuong cua lop PaymentTransaction
     * @param errorCode - ma loi
     * @param card - the thanh toan giao dich
     * @param transactionId - ma giao dich
     * @param transactionContent - noi dung giao dich
     * @param amount - so tien can thanh toan
     * @param createdAt - thowi gian thue xe
     */
    public PaymentTransaction(String errorCode, Card card, String transactionId, String transactionContent, int amount, String createdAt) {
        this.errorCode = errorCode;
        this.card = card;
        this.transactionId = transactionId;
        this.transactionContent = transactionContent;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionContent() {
        return transactionContent;
    }

    public void setTransactionContent(String transactionContent) {
        this.transactionContent = transactionContent;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}