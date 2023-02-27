package week2.cc;

import java.time.LocalDate;

public class CreditCard {
    private final String cardNumber;
    private final LocalDate expiration;
    private final String cardholderName;

    public CreditCard(String cardNumber, LocalDate expiration, String cardholderName){
        this.cardNumber = cardNumber;
        this.expiration = expiration;
        this.cardholderName = cardholderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public String getCardholderName() {
        return cardholderName;
    }
}
