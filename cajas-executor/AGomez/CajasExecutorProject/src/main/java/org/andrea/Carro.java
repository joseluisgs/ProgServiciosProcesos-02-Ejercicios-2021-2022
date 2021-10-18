package org.andrea;
import lombok.Data;


@Data
public class Carro {

    private Producto[] productos;
    private final int MAX_PRODUCTOS=30;

    //el carro tendrá un máximo de 30 productos
    public Carro() {

        this.productos = new Producto[(int) ((Math.random() * MAX_PRODUCTOS) + 1)];
        for(int i=0; i< productos.length;i++){
            productos[i] = new Producto(i+1);
        }


    }
}
