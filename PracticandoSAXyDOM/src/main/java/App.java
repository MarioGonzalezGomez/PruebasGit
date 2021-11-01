import controller.SAXHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        String ruta = "https://www.esmadrid.com/opendata/alojamientos_v1_es.xml";
        XMLReader reader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        SAXHandler handler = new SAXHandler();
        reader.setContentHandler(handler);
        reader.parse(ruta);
    }
}
