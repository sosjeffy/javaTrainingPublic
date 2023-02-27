package week2.cc.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class XMLParser extends Parser {
    @Override
    public void parseCreditCards(String filepath) {
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        try (InputStream inputStream = Files.newInputStream(Path.of(filepath))){
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document cards = builder.parse(inputStream);
            // Normalize: remove unnecessary things like whitespaces, line breaks, comments, etc
            cards.getDocumentElement().normalize();
            Element element = cards.getDocumentElement();
            //NodeList nList = cards.getElementsByTagName("root");
            System.out.println(element.toString());
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
}