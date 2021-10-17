import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Mario\\Desktop\\titulares.xml");
        LectorDOM dom = new LectorDOM();
        Documento document = dom.leerDocumento(file);
        document.printRss(document);

    }
}
