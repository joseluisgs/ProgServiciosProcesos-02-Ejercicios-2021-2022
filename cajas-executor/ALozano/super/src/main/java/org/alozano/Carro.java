package org.alozano;

import lombok.Data;

import java.util.Random;

@Data
public class Carro {
    private Producto[] productos;

    public Carro(){
        //this.productos = new Producto[(int)((Math.random()*30)+1)];
        this.productos = new Producto[new Random().nextInt(30)+1];
        for(int i=0; i<productos.length; i++){
            productos[i] = new Producto(i+1);
        }
    }

}
