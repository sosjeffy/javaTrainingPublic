package week2.cc.parsers;

import week2.cc.AmExCC;
import week2.cc.CreditCard;
import week2.cc.MasterCC;
import week2.cc.VisaCC;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Parser {
    private final List<CreditCard> creditCards;
    Parser(){
        creditCards = new ArrayList<>();
    }
    abstract public void parseCreditCards(String filepath);
    //Protected: anything in same package AND all subclasses (even in different packages) can access
    protected boolean validCardNumber(String cardNumber){
        return cardNumber.length() <= 19;
    }
    private CreditCard createCard(String cardNumber, LocalDate date, String cardholderName){
        int firstDigit = Character.getNumericValue(cardNumber.charAt(0));
        if (validCardNumber(cardNumber)){
            // Mastercard
            if (firstDigit == 5){
                int secondDigit = Character.getNumericValue(cardNumber.charAt(1));
                if (cardNumber.length() == 16 && secondDigit >= 1 && secondDigit <= 5){
                    return new MasterCC(cardNumber, date, cardholderName);
                }
            }
            // Visa
            else if (firstDigit == 4 && (cardNumber.length() == 13 || cardNumber.length() == 16)){
                return new VisaCC(cardNumber, date, cardholderName);
            }
            //American Express
            else if (firstDigit == 3){
                int secondDigit = Character.getNumericValue(cardNumber.charAt(1));
                if ((secondDigit == 4 || secondDigit == 7) && cardNumber.length() == 15){
                    return new AmExCC(cardNumber, date, cardholderName);
                }
            }
        }
        //Not a valid card number
        return new CreditCard(cardNumber, date, cardholderName);
    }
    protected LocalDate parseDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");
        return LocalDate.parse(date, formatter);
    }
    protected void addCardIfValid(String cardNumber, LocalDate date, String cardholderName){
        if (validCardNumber(cardNumber)){
            creditCards.add(createCard(cardNumber, date, cardholderName));
        }
    }

    public List<CreditCard> getCreditCards(){
        return creditCards;
    }
}