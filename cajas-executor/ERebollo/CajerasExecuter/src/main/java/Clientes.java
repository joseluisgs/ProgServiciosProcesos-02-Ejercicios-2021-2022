import lombok.Data;

import java.util.ArrayDeque;

@Data
public class Clientes {
    private ArrayDeque<Cliente> clientes = new ArrayDeque<>();

    public Clientes (int clientes){
        addClients(clientes);
    }
    private void addClients(int numeroClientes){
        for(int i=0;i<numeroClientes;i++){
            clientes.add(new Cliente(i));
        }
    }
}
