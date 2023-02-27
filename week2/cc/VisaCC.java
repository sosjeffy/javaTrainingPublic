package week2.cc;

import java.time.LocalDate;

public class VisaCC extends CreditCard{
    public VisaCC(String cardNumber, LocalDate expiration, String cardholderName) {
        super(cardNumber, expiration, cardholderName);
    }
}
