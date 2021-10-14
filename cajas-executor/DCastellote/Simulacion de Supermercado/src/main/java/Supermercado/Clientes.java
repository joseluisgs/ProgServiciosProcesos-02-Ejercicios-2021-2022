package Supermercado;

import java.util.Collections;
import java.util.LinkedList;

public class Clientes {
    private static LinkedList clientesLista;
    private static Clientes clientes;
    static int numClientes;

    private Clientes() {

    }

    public static Clientes generarClientes(int Clientes) {
        if (clientes == null) {
            clientes = new Clientes();
            numClientes = Clientes;
            crearClientes(clientes);
        }
        return clientes;
    }


    private static void crearClientes(Clientes clientela) {
        clientesLista = new LinkedList();
        for (int i = 0; i < numClientes; i++) {
            Cliente cliente = new Cliente();
            encolar(cliente);
        }
    }

    public static LinkedList getClientesLista() {
        return clientesLista;
    }

    public static void setClientesLista(LinkedList clientesLista) {
        Clientes.clientesLista = clientesLista;
    }

    public static Clientes getClientes() {
        return clientes;
    }

    public static void setClientes(Clientes clientes) {
        Clientes.clientes = clientes;
    }

    public static void encolar(Cliente cliente) {
        clientesLista.add(cliente);
    }

    public Cliente desencolar() {
        return (Cliente) clientesLista.removeFirst();
    }

    public void mostrar() {
        System.out.println(clientesLista);
    }

    public void ordenar() {
        Collections.sort(clientesLista);
    }

    public static int getNumClientes() {
        return numClientes;
    }

    public static void setNumClientes(int numClientes) {
        Clientes.numClientes = numClientes;
    }
}
