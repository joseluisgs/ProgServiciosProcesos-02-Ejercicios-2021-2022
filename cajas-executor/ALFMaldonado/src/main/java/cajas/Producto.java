package cajas;

import lombok.Data;

@Data
public class Producto {
    private int numProducto;
    private int tiempoEnProcesar;


    public Producto(int numProduct) {
        this.numProducto = numProduct;
        this.tiempoEnProcesar = (int) ((Math.random() * 5)+1);
    }

}
