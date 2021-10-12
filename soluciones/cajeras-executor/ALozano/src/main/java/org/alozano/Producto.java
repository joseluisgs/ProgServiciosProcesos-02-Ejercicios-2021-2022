package org.alozano;

import lombok.Data;

@Data
public class Producto {
    private int numProductos;
    private int tiempoProcesamiento;

    public Producto(int numProductos){
        this.numProductos = numProductos;
        this.tiempoProcesamiento = (int) ((Math.random()*5)+1);
    }
}
