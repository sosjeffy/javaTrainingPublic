package week2.cc.writers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import week2.cc.CreditCard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
public class JSONWriter extends Writer{
    @Override
    public void writeToFile(List<CreditCard> creditCards, String filepath) {
        JSONArray jsonArray = new JSONArray();
        File JSONOutputFile = new File(filepath);
        creditCards.stream().forEach(creditCard -> jsonArray.add(createJsonObject(creditCard)));
        try (PrintWriter pw = new PrintWriter(JSONOutputFile)) {
            pw.write(jsonArray.toJSONString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private JSONObject createJsonObject(CreditCard creditCard){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cardNumber", creditCard.getCardNumber());
        String cardType = creditCard.getClass() != CreditCard.class
                ? creditCard.getClass().toString().substring(15)
                : "invalid";
        jsonObject.put("cardType", cardType);
        return jsonObject;
    }
}