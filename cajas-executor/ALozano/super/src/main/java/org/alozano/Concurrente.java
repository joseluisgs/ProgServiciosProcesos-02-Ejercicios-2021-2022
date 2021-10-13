package org.alozano;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Concurrente {
    public static void cajeraConcurrente(int numeroCajeras, int numeroClientes){
        System.out.println("-----------------------INICIA PROGRAMA DE FORMA CONCURRENTE----------------------------");
        long init = System.currentTimeMillis();  // Instante inicial del procesamiento

        //Creación del pool
        ExecutorService executor = Executors.newFixedThreadPool(numeroCajeras);

        //Lista clientes
        ArrayList<Cliente> clientes = new ArrayList<>(numeroClientes);
        for (int i = 0; i < numeroClientes; i++) {
            clientes.add(new Cliente(i + 1));
        }

        for (Cliente cliente : clientes) {
            Runnable cajera = new Cajera(cliente, init);
            executor.execute(cajera);
        }

        executor.shutdown();    // apago el Executor
        //Para que hasta que no termine la ejecución de los procesos que ejecuta el "executor" no ejecute los siguientes
        while (!executor.isTerminated()) {
            // Espero a que terminen de ejecutarse todos los procesos para pasar a las siguientes instrucciones
        }

        long fin = System.currentTimeMillis();    // Instante final del procesamiento
        //Tiempo total
        System.out.println("Tiempo total de procesamiento: " + (fin - init) / 1000 + " Segundos");
        System.out.println("-----------------------FINALIZA PROGRAMA DE FORMA CONCURRENTE----------------------------");
    }
}
