package org.andrea;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
public class Super {

    private int numClientes;
    private int numCajas;

    Deque<Cliente> colaClientesConcurrente;
    Deque<Cliente> colaClientesSecuencial;
    private String numCaja;
    Clientes clientes;
    ArrayDeque<Cliente> colaClientes;



    //Metemos los parámetros en el constructor, así nos aseguramos de que ambos métodos trabajan con los mismos datos.
    public Super(int numClientes, int numCajas) {

        this.numClientes = numClientes;
        this.numCajas = numCajas;
        clientes= new Clientes(numClientes);
        colaClientes = clientes.getColaClientes();
    }

    //Creamos clientes añadiéndose a dos colas de clientes.
    public void initComponents() {

        for (int i = 0; i < numClientes; i++) {

        }
    }
    //Una tarea no empezará hasta que termine la anterior
    public void procesoSecuencial() {


        System.out.println("***INICIO PROCESO SECUENCIAL***");

        for(int i=0; i<numClientes;i++){


            for (int n = 0; n < numCajas; n++) {
                if (!colaClientes.isEmpty()) {
                    Caja caja=new Caja(colaClientes.getFirst(), colaClientes.getFirst().getNombreCliente(), "Caja: "+i);
                    caja.procesarCompra();
                    colaClientes.pop();
                }
                else{
                    break;
                }
            }
            System.out.println("****HA TERMINADO EL PROCESO SECUENCIAL****");
        }










    }
    public void procesoConcurrente() {
        System.out.println("***INICIO PROCESO CONCURRENTE***");

        ExecutorService executor = Executors.newFixedThreadPool(numCajas);

            while (colaClientes.size() > 0) {

                for (int i = 0; i < numCajas; i++) {
                    Runnable worker = new Caja(colaClientes.getFirst(), colaClientes.getFirst().getNombreCliente(), "Caja: "+i);

                    String[] workerArray=worker.toString().split(",");
                    for (String item:workerArray
                         ) {
                        if(item.contains("nombreCaja")){
                            numCaja=item;
                        }

                    }

                    executor.execute(worker);
                    colaClientes.pop();
                    System.out.println("CAJA NUMERO ----> "+ numCaja);
                }

            }


        System.out.println("****HA TERMINADO EL PROCESO CONCURRENTE****");
        executor.shutdown();

    }
}








