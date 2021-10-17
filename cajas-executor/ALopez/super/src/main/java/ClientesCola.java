import lombok.Data;

import java.util.ArrayDeque;

@Data

public class ClientesCola {
    //creamos una cola de clientes que añadira los clientes 1 a 1
    private ArrayDeque<Cliente> clientesCola = new ArrayDeque<>();

    public ClientesCola(int numeroDeClientes) {
        this.clientesCola = new ArrayDeque<>(numeroDeClientes);
        for (int i = 0; i < numeroDeClientes; i++) {

            clientesCola.add(new Cliente(i + 1));
        }

    }

}
