package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Alojamiento {
    private String title;
    private String fxActualizacion;
    private Media imagen;
    private String calle;
    private String codPostal;
    private String descripcion;


    public void imprimirAlojamiento() {
        System.out.println(title);
        System.out.println("\tCon última fecha de actualización el :" + fxActualizacion);
        if (imagen != null)
            System.out.println(imagen);
        System.out.println("\tSituado en Madrid, con dirección: " + calle + " --Código postal: " + codPostal);
        System.out.println("\t\t" + descripcion + "\n\n");
    }
}
