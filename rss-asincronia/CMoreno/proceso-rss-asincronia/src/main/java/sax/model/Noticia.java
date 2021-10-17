package sax.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Noticia implements Serializable {
    private String titulo;
    private String link;
    private String descripcion;
    private String imagen;
    private String fecha;
    private String categoria;

    public String toString() {
        return "*** sax.model.Noticia ***" + "\n" +
                "\t--> Titular: " + this.titulo + "\n" +
                "\t--> Enlace: " + this.link + "\n" +
                "\t--> Descripción: " + this.descripcion + "\n" +
                "\t--> Imagen: " + this.imagen + "\n" +
                "\t--> Fecha: " + this.fecha + "\n" +
                "\t--> Categoría: " + this.categoria + "\n";
    }
}
