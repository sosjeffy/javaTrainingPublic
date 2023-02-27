package week2.cc.parsers;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class CSVParser extends Parser {
    @Override
    public void parseCreditCards(String filepath) {
        try {
            Scanner sc = new Scanner(new File(filepath));
            sc.useDelimiter("\n");
            sc.nextLine(); // Skip first line describing what each column is
            while (sc.hasNext()){
                String[] line = sc.next().split(",");
                String cardNumber = line[0];
                LocalDate date = parseDate(line[1]);
                String cardholderName = line[2];
                addCardIfValid(cardNumber, date, cardholderName);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}