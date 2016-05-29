package util.xml;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 *
 * @author Lama
 */
public class XMLWriter {

    public XMLWriter(File file) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
    }
}
