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
        if(args.length==2){ //Verifico que se introducen dos argumentos
            int numeroCajeras = Integer.parseInt(args[0]);
            int numeroClientes = Integer.parseInt(args[1]);

            long init = System.currentTimeMillis();  // Instante inicial del procesamiento


            //Lista clientes
            ArrayList<Cliente> clientes = new ArrayList<>(numeroClientes);
            for (int i = 0; i < numeroClientes; i++) {
                clientes.add(new Cliente(i + 1));
            }

            //Creación del pool
            ExecutorService executor = Executors.newFixedThreadPool(numeroCajeras);

            for (Cliente cliente : clientes) {
                //Runnable cajera = new CajeraRunnable(cliente, init);
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


        }else{
            System.err.println("Parámetros invalidos introduzca dos prarametros: " +
                    "siendo el primero el número de cajeras y el segundo el número de clientes");
        }

    }
}
