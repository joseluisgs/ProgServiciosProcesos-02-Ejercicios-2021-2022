package cajas;

import lombok.Data;
import java.util.ArrayDeque;

@Data
public class Clientes {
    private ArrayDeque<Cliente> colaClientes;

    public Clientes(int numElements) {
        this.colaClientes = new ArrayDeque<>(numElements);
        for (int i = 0; i<numElements;i++ ){
            colaClientes.add(new Cliente(i+1));
        }
    }
}
