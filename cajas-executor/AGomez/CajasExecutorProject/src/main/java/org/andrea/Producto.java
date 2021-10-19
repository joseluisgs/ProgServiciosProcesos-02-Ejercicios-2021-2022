package org.andrea;
import lombok.Data;


@Data
public class Producto {

    private long tiempoEnProcesar;
    private int idProducto;
    private final int MAX_SEGUNDOS = 5;


    //tiempo de procesamiento del producto maximo 1 a 5 segundos
    public Producto(int idProducto){

        this.idProducto= idProducto;
        this.tiempoEnProcesar = (int) ((Math.random()*MAX_SEGUNDOS)+1);
    }

}
