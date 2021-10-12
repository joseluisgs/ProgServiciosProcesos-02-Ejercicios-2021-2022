package org.alozano;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App {


    public static void main( String[] args )
    {
        int numeroCajeras = Integer.parseInt("2");
        int numeroClientes = Integer.parseInt("5");
        long init = System.currentTimeMillis();  // Instante inicial del procesamiento
        long fin = System.currentTimeMillis();	// Instante final del procesamiento

        //Lista clientes
        ArrayList<Cliente> clientes = new ArrayList<>(numeroClientes);
        for(int i = 0; i < numeroClientes; i++){
            clientes.add(new Cliente(i+1));
        }

        //Creación del pool
        ExecutorService executor = Executors.newFixedThreadPool(numeroCajeras);

        for (Cliente cliente: clientes) {
            //Runnable cajera = new CajeraRunnable(cliente, init);
            Runnable cajera = new Cajera(cliente, init);
            executor.execute(cajera);
        }

        executor.shutdown();	// apago el Executor
        //Para que hasta que no termine la ejecución de los procesos que ejecuta el "executor" no ejecute los siguientes
        while (!executor.isTerminated()) {
            // Espero a que terminen de ejecutarse todos los procesos para pasar a las siguientes instrucciones
        }

        //Tiempo total
        System.out.println("Tiempo total de procesamiento: "+(fin-init)/1000+" Segundos");

    }
}
