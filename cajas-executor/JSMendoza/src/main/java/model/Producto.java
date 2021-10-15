package model;

import lombok.Data;

@Data
public class Producto {
    private int numProductos;
    private static final int TIEMPO_MAX = 5;
    private int tiempoProcesamiento = (int) ((Math.random() * TIEMPO_MAX) + 1);

    public Producto() {
    }

    public Producto(int numProduct) {
        this.numProductos = numProduct;
    }
}
