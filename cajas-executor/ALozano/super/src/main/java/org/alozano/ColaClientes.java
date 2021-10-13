package org.alozano;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.ArrayList;

@Data
public class ColaClientes {
    private ArrayDeque<Cliente> colaClientes;
    //Cola clientes
    public ColaClientes(int numeroClientes){
        this.colaClientes = new ArrayDeque<>(numeroClientes);
        for (int i = 0; i < numeroClientes; i++) {
            colaClientes.add(new Cliente(i + 1));
        }
    }



}
