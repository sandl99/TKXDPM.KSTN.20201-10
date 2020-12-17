package subsystem.banksubsystem.interbank;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.*;
import exception.PaymentException;
import subsystem.banksubsystem.utils.Config;
import subsystem.banksubsystem.utils.JSonUtils;
import subsystem.banksubsystem.utils.Utils;
import exception.*;

public class InterbankSubsystemController {
    private static InterbankBoundary interbankBoundary = new InterbankBoundary();

    /**
     * query and get a Payment Transaction
     * @param card
     * @param amount
     * @param contents
     * @return
     */
    public PaymentTransaction pay(Card card, int amount, String contents) throws PaymentException {
        JsonObject jsonObject = JSonUtils.getTransaction(Config.payComment, contents, amount);

        String responseText = interbankBoundary.query(Config.baseUrl + Config.transactionUrl, jsonObject.toString());
        System.out.println(responseText);
        return extractPaymentTransaction(responseText);
    }

    /**
     * query and refund transaction
     * @param card
     * @param amount
     * @param contents
     * @return
     */
    public PaymentTransaction refund(Card card, int amount, String contents) throws PaymentException {
        JsonObject jsonObject = JSonUtils.getTransaction(Config.refundComment, contents, amount);

        String respondText = interbankBoundary.query(Config.baseUrl + Config.transactionUrl, jsonObject.toString());
        return extractPaymentTransaction(respondText);
    }

    private PaymentTransaction extractPaymentTransaction(String respond) throws PaymentException {
        Card card = Card.getInstance();
        JsonObject respondJson = new JsonParser().parse(respond).getAsJsonObject();
        String errCode = respondJson.get("errorCode").getAsString();

        switch (errCode) {
            case "00":
                break;
            case "01":
                throw new InvalidCardException();
            case "02":
                throw new NotEnoughBalanceException();
            case "03":
                throw new InternalServerErrorException();
            case "04":
                throw new SuspiciousTransactionException();
            case "05":
                throw new NotEnoughTransactionInfoException();
            case "06":
                throw new InvalidVersionException();
            case "07":
                throw new InvalidTransactionAmountException();
            default:
                throw new UnrecognizedException();
        }

        JsonObject transactionJson = respondJson.getAsJsonObject("transaction");

        if (card.equals(transactionJson.get("cardCode").getAsString())) {
            Utils.LOGGER.warning("ID Card not match with respond card");
        }
        card.setAmount(1000);

        String transactionId = transactionJson.get("transactionId").getAsString();
        String transactionContent = transactionJson.get("transactionContent").getAsString();
        int amount = transactionJson.get("amount").getAsInt();
        String createdAt = transactionJson.get("createdAt").getAsString();
        return new PaymentTransaction(errCode, card, transactionId, transactionContent, amount, createdAt);
    }

    public String reset() {
        JsonObject jsonObject = new JsonObject();
        Card card = Card.getInstance();

        jsonObject.addProperty("cardCode", card.getId());
        jsonObject.addProperty("owner", card.getOwner());
        jsonObject.addProperty("cvvCode", card.getCvv());
        jsonObject.addProperty("dateExpired", card.getDateExpire());

        String respondText = interbankBoundary.query(Config.baseUrl + Config.resetUrl, jsonObject.toString());
        return respondText;
    }
    public static void main(String[] args) {
        InterbankSubsystemController interbankSubsystemController = new InterbankSubsystemController();
        System.out.println(interbankSubsystemController.reset());
//        System.out.println(interbankSubsystemController.pay(Card.getInstance(), 2000000, "San rut tien"));
    }
}
