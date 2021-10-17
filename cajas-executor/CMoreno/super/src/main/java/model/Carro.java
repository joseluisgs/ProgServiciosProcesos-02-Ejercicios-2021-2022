package model;

import lombok.Data;

import java.util.Random;

@Data
public class Carro {
    static final int MAX_PRODUCTOS = 30;
    private Producto[] productos;

    // Coonstructor dónde los productos pueden variar de manera aleatoria de 1 a 30 y se introducen los productos al carro
    Carro() {
        productos = new Producto[new Random().nextInt(MAX_PRODUCTOS) + 1];
        introducirProductos();
    }
    // Método para introducir los productos al carro
    private void introducirProductos() {
        for(int i = 0; i < productos.length; i++) {
            productos[i] = new Producto();
        }
    }
}