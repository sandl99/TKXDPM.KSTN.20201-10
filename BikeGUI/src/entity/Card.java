package entity;

/**
 *
 * @author san.dl170111
 */

public class Card {
    private String id;
    private String owner;
    private String ccv;
    private String dateExpire;

    private int amount;

    private static Card card = null;

    public Card(String id, String owner, String ccv, String dateExpire) {
        this.id = id;
        this.owner = owner;
        this.ccv = ccv;
        this.dateExpire = dateExpire;
    }

    public String getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCvv() {
        return ccv;
    }

    public void setCvv(String ccv) {
        this.ccv = ccv;
    }

    public String getDateExpire() {
        return dateExpire;
    }

    public void setDateExpire(String dateExpire) {
        this.dateExpire = dateExpire;
    }

    public static Card getInstance() {
        if (card == null) {
            card = new Card("118131_group10_2020", "Group 10", "312", "1125");
        }
        return card;
    }

    public boolean equals(String id) {
        return this.id.equals(id);
    }
}
