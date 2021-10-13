package org.alozano;

import lombok.Data;

import java.util.Random;

@Data
public class Producto {
    private int numProductos;
    private int tiempoProcesamiento;

    public Producto(int numProductos){
        this.numProductos = numProductos;
        //this.tiempoProcesamiento = (int) ((Math.random()*5)+1);
        this.tiempoProcesamiento = new Random().nextInt(5)+1;
    }
}
