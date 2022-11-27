package entities;

public class CreditCard {

    int cardNumber;
    String cardHolderName;
    int expiryDate;
    int securityCode;

    public CreditCard(int cardNumber, String cardHolderName, int expiryDate, int securityCode) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.securityCode = securityCode;
    }
}
