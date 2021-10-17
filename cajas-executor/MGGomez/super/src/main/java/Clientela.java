import java.util.Collections;
import java.util.LinkedList;


public class Clientela {
    private static LinkedList clientes;
    private static Clientela clientela;
    static int numClientes;

    private Clientela() {

    }

    public static Clientela generarClientela(int Clientes) {
        if (clientela == null) {
            clientela = new Clientela();
            numClientes = Clientes;
            crearClientela(clientela);
        }
        return clientela;
    }


    private static void crearClientela(Clientela clientela) {
        clientes = new LinkedList();
        for (int i = 0; i < numClientes; i++) {
            Cliente cliente = new Cliente();
            encolar(cliente);
        }
    }

    public static LinkedList getClientes() {
        return clientes;
    }

    public static void setClientes(LinkedList clientes) {
        Clientela.clientes = clientes;
    }

    public static Clientela getClientela() {
        return clientela;
    }

    public static void setClientela(Clientela clientela) {
        Clientela.clientela = clientela;
    }

    public static void encolar(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente desencolar() {
        return (Cliente) clientes.removeFirst();
    }

    public void mostrar() {
        System.out.println(clientes);
    }

    public void ordenar() {
        Collections.sort(clientes);
    }

}
