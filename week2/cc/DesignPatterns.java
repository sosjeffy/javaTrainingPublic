package week2.cc;

import week2.cc.parsers.CSVParser;
import week2.cc.parsers.JSONFileParser;
import week2.cc.parsers.XMLParser;
import week2.cc.writers.CSVWriter;
import week2.cc.writers.JSONWriter;

// Design pattern chosen is factory method because most methods in the various parsers are identical.
// The only change is the way in which the factory method does the parsing of files.
public class DesignPatterns {
    public static void main(String[] args) {
        CSVParser cp = new CSVParser();
        cp.parseCreditCards("week2/cc/ccdata/CC.csv");
        CSVWriter cw = new CSVWriter();
        cw.writeToFile(cp.getCreditCards(), "week2/cc/ccdata/CSVWrite.csv");

        JSONFileParser jp = new JSONFileParser();
        jp.parseCreditCards("week2/cc/ccdata/cc.json");
        JSONWriter jw = new JSONWriter();
        jw.writeToFile(jp.getCreditCards(), "week2/cc/ccdata/JSONWrite.json");

        XMLParser xp = new XMLParser();
        //xp.parseCreditCards("week2/cc/ccdata/cc.xml");

        //    week2/cc/ccdata/CSVWrite.csv


    }
}
