package org.andrea;

import java.util.*;

import lombok.Data;

//esta clase es una cola de cliente
@Data

public class Clientes extends ArrayDeque<Cliente> {
    private ArrayDeque<Cliente> colaClientes;

    //le indicamos por parámetro el numero de clientes que vamos a querer.
    public Clientes(int numClientes) {

        colaClientes = new ArrayDeque<>(numClientes);

        //creamos los clientes y los asignamos a la cola en la última posición.

        for (int i = 0; i < numClientes; i++) {

            colaClientes.offerLast(new Cliente("" + (i + 1)));
        }
    }

    public Deque<Cliente> returnCola() {

        return colaClientes;
    }
}
