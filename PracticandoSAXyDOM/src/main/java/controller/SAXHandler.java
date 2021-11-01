package controller;

import model.Alojamiento;
import model.Media;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import java.util.LinkedList;
import java.util.List;


public class SAXHandler implements ContentHandler {
    private static final String SERVICE = "service";
    private static final String FECHA_ACTUALIZACION = "fechaActualizacion";
    private static final String TITLE = "title";
    private static final String ADDRESS = "address";
    private static final String ZIP_CODE = "zipcode";
    private static final String BODY = "body";

    private static final String MEDIA = "media";
    private static final String MEDIA_TYPE = "type";
    private static final String URL = "url";

    private static Alojamiento currentAlojamiento;
    private static Media media;
    private List<Alojamiento> alojamientos;

    private static String Q_NAME;

    @Override
    public void startDocument() throws SAXException {
        alojamientos = new LinkedList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        switch (qName) {
            case SERVICE:
                currentAlojamiento = new Alojamiento();
                for (int i = 0; i < atts.getLength(); i++) {
                    switch (atts.getQName(i)) {
                        case FECHA_ACTUALIZACION:
                            currentAlojamiento.setFxActualizacion(atts.getValue(i));
                            break;
                    }
                }
                break;
            case MEDIA:
                media = new Media();
                for (int i = 0; i < atts.getLength(); i++) {
                    switch (atts.getQName(i)) {
                        case MEDIA_TYPE:
                            media.setType(atts.getValue(i));
                            break;
                    }
                }
                break;
            default:
                Q_NAME = qName;
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (length > 0) {
            String contenido = String.valueOf(ch, start, length);
            if (!contenido.isBlank()) {
                switch (Q_NAME) {
                    case TITLE:
                        currentAlojamiento.setTitle(contenido);
                        break;
                    case MEDIA:
                    case ADDRESS:
                        currentAlojamiento.setCalle(contenido);
                        break;
                    case ZIP_CODE:
                        currentAlojamiento.setCodPostal(contenido);
                        break;
                    case BODY:
                        currentAlojamiento.setDescripcion(contenido);
                        break;
                    case URL:
                        media.setUrl(contenido);
                }
            }
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(MEDIA)) {
            currentAlojamiento.setImagen(media);
            media = null;
        }
        if (qName.equals(SERVICE)) {
            alojamientos.add(currentAlojamiento);
            currentAlojamiento = null;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        alojamientos.forEach(Alojamiento::imprimirAlojamiento);
    }


    /////// Métodos que no necesitaremos

    @Override
    public void setDocumentLocator(Locator locator) {

    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {

    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {

    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {

    }

    @Override
    public void skippedEntity(String name) throws SAXException {

    }
}
