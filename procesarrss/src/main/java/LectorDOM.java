import lombok.AllArgsConstructor;
import lombok.Data;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class LectorDOM {


    public Documento leerDocumento(File file) {
        try {
            Documento procesado = new Documento();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.normalize();

            NodeList noticias = doc.getElementsByTagName("item");
            procesado.setNumNoticias(noticias.getLength());
            procesado.setFxPub(doc.getElementsByTagName("pubDate").item(0).getTextContent());
            leerNoticias(procesado, noticias);

            return procesado;


        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }

    private void leerNoticias(Documento procesado, NodeList noticias) {
        ArrayList<Noticia> news = new ArrayList<>();
        Noticia noticia;
        try {
            for (int i = 0; i < noticias.getLength(); i++) {
                Node nNode = noticias.item(i);
                noticia =new Noticia();
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    noticia.setTitular(eElement.getElementsByTagName("title").item(0).getTextContent());


                    if (eElement.getElementsByTagName("content:encoded").item(0) == null) {
                        noticia.setBody(eElement.getElementsByTagName("description").item(0).getTextContent());

                    } else {
                        noticia.setBody(eElement.getElementsByTagName("content:encoded").item(0).getTextContent());
                    }
                    noticia.setAuthors(eElement.getElementsByTagName("dc:creator").item(0).getTextContent());
                    noticia.setLink(eElement.getElementsByTagName("link").item(0).getTextContent());

                }
                news.add(noticia);

            }
            procesado.setNoticias(news);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}