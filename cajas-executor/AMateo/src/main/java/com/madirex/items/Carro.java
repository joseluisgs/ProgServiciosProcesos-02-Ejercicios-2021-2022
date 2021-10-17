package com.madirex.items;

import com.madirex.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;

@Data
@AllArgsConstructor
public class Carro {

    private final int MAX_PRODUCTOS_CARRO = 30;
    private final int random = (int) (MAX_PRODUCTOS_CARRO * Math.random() + 1);
    private Producto[] productos = new Producto[random];

    public Carro(){

        //Crear productos
        for(int i = 0; i< random; i++){
            Producto producto = new Producto("Producto " + (i + 1));;
            productos[i] = producto;
        }
    }
}
