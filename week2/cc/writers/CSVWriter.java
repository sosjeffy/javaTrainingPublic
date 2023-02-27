package week2.cc.writers;

import week2.cc.CreditCard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringJoiner;

public class CSVWriter extends Writer{
    @Override
    public void writeToFile(List<CreditCard> creditCards, String filepath) {
        File csvOutputFile = new File(filepath);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            creditCards.stream()
                    .map(this::generateCCLine)
                    .forEach(pw::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateCCLine(CreditCard creditCard){
        StringJoiner sj = new StringJoiner(",");
        sj.add(creditCard.getCardNumber());
        sj.add(creditCard.getClass() != CreditCard.class
                ? creditCard.getClass().toString().substring(15)
                : "invalid");
        return sj.toString();
    }
}