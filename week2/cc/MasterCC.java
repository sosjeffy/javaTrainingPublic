package week2.cc;

import java.time.LocalDate;

public class MasterCC extends CreditCard{
    public MasterCC(String cardNumber, LocalDate expiration, String cardholderName) {
        super(cardNumber, expiration, cardholderName);
    }
}
