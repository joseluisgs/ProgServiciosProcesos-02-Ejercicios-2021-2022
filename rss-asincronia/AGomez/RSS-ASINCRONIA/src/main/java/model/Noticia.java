package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Noticia {


    private String titulo;
    private String link;
    private String creador;
    private String descripcion;
    private String fechaPublicacion;


    public String toString() {
        return "* Noticia: " + "\n" +

                "\t--> Titular: " + this.titulo + "\n" +
                "\t--> Link: " + this.link + "\n" +
                "\t--> Creador: " + this.creador + "\n" +
                "\t--> Descripción: " + this.descripcion + "\n" +
                "\t--> Fecha de publicación: " + this.fechaPublicacion + "\n" ;
    }
}


