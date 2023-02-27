package week2.cc.writers;

import week2.cc.CreditCard;

import java.util.List;

public abstract class Writer {
    public abstract void writeToFile(List<CreditCard> creditCards, String filepath);
}