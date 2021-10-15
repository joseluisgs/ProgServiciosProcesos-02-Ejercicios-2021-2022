package model;

import lombok.Data;

import java.util.ArrayDeque;

@Data
public class Clientes {
    private ArrayDeque<Cliente> clientQueue;

    public Clientes(int numClientes) {
        this.clientQueue = new ArrayDeque<>(numClientes);
        for (int i = 0; i < numClientes; i++) {
            clientQueue.add(new Cliente(i + 1));
        }
    }
}
