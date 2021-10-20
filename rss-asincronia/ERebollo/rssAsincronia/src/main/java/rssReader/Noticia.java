package rssReader;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Noticia {
    private String nombre, uri, descripcion, contenido, fecha;
    private List<String> categorias;

    public String toString(){
        return "ultima hora: "+
                nombre+"\n"+
                "link: "+uri+"\n"+
                "\n"+descripcion+"\n"+
                contenido+"\n"+fecha;

    }
}
