package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Media {
    private String type;
    private String url;

    @Override
    public String toString() {
        return "Este alojamiento dispone de archivos multimedia de tipo " + type + " en: \n" + url;
    }
}
