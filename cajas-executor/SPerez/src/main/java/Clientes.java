import java.util.LinkedList;

public class Clientes {
    private LinkedList<Cliente> cola;
    private int siguienteCliente = 0;

    public Clientes (int nClientes) {
        this.cola = new LinkedList<>();
        generarClientes(nClientes);
    }

    private void generarClientes(int nClientes) {
        for(int i = 0; i < nClientes; i++)
            this.cola.add(new Cliente(i));
    }

    public Cliente siguienteCliente() {
        return this.cola.get(this.siguienteCliente++);
    }

    public boolean isEmpty() {
        return this.cola.size() <= this.siguienteCliente;
    }

    public void resetClientes() {
        this.siguienteCliente = 0;
    }
}
