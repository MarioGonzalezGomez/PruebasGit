import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Documento {
    ArrayList<Noticia> noticias;
    int numNoticias;
    String fxPub;


    public void printRss(Documento doc) {
        System.out.println("El número de noticias total es de " + doc.getNumNoticias());
        System.out.println("Fecha de la publicación: " + doc.getFxPub() + "\n\n");

        for (int i = 0; i < doc.getNoticias().size(); i++) {
            System.out.println(doc.getNoticias().get(i).getTitular() + "\n");
            System.out.println("\t" + doc.getNoticias().get(i).getBody());
            System.out.println("\t\t-Autor-Autores: " + doc.getNoticias().get(i).getAuthors());
            System.out.println("\t\t\t- Para más información, consulata el link de la publicación: " + doc.getNoticias().get(i).getLink());
            System.out.println("\n\n");
        }

    }

}
