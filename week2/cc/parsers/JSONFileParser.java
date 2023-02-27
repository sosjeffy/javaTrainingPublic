package week2.cc.parsers;
// For this to work, you need to add json simple as dependency:
// https://www.geeksforgeeks.org/how-to-add-external-jar-file-to-an-intellij-idea-project/
// http://www.java2s.com/Code/Jar/j/Downloadjsonsimple11jar.htm
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class JSONFileParser extends Parser {
    @Override
    public void parseCreditCards(String filepath) {
        try {
            Object object = new JSONParser().parse(new FileReader(filepath));
            List<JSONObject> jsonObj = (List<JSONObject>) object;
            for (JSONObject jsonCard : jsonObj) {
                // CardNumber is actually a Long but .get() returns it as Object
                addCardIfValid(
                        Long.toString((Long) jsonCard.get("CardNumber")),
                        parseDate((String) jsonCard.get("ExpirationDate")),
                        (String) jsonCard.get("NameOfCardholder")
                        );
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}