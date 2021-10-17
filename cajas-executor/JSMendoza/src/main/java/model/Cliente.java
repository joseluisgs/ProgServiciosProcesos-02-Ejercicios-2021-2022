package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cliente {
    private int numClientes;
    private Carrito carritos;

    public Cliente(int numClientes) {
        this.numClientes = numClientes;
        this.carritos = new Carrito();
    }
}
