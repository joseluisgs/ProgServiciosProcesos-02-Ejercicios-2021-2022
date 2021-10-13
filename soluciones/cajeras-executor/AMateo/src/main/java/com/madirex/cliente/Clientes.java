package com.madirex.cliente;

import com.madirex.cliente.Cliente;

import java.util.LinkedList;

public class Clientes extends LinkedList<Cliente>{
    private boolean hayClientes = false;
    private int maxClientes;
    private Cliente c;

    public Clientes(int maxClientes){
        this.maxClientes = maxClientes;
    }

    public synchronized Cliente salir(){
        while((this.size()==0)) {
            try {
                // Si no tiene que salir, esperamos,
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        c = this.removeFirst(); // Saco el primero
        //System.out.println("\t*Hay " + this.size() + " clientes en total.");
        hayClientes = false;

        // Activamos
        notifyAll();

        return c;
    }

    public synchronized void entrar(Cliente c){
        while((this.size()==this.maxClientes)) {	// Condición de memoria limitada
            try {
                // Si no entra, esperamos
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        this.addLast(c); //Entra al final de la cola
        hayClientes = true;

        // Activamos
        notifyAll();
    }
}
