package util.xml;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author Lama
 */
public class XMLParser {

    File file;
    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    Document document;
    Element root;

    public XMLParser(String filePath) {
        this.file = new File(filePath);
        this.factory = DocumentBuilderFactory.newInstance();
        try {
            this.builder = factory.newDocumentBuilder();
            this.document = builder.parse(file);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.root = (Element) document.getDocumentElement();
    }

    public Element getElementByTagName(String tagName) {
        return (Element) this.root.getElementsByTagName(tagName);
    }

    public Element getElementById(String id) {
        return (Element) this.document.getElementById(id);
    }

}
