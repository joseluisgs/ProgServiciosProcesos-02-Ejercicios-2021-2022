package ejercicio.CajasColas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProcesarCaja {
    public static void main(String[] args) {

        //Atributos que pasamos como argumentos
        int numCajeros = Integer.parseInt(args[0]);
        int numClientes = Integer.parseInt(args[1]);

        //Cola de clientes
        Queue<Cliente> clientes;
        clientes = new LinkedList();
        //Recorremos el num de clientes y los añadimos a cola de clientes;
        for (int i = 1; i < numClientes; i++) {
            Cliente cliente = new Cliente(" nº" + i);
            clientes.add(cliente);
        }


        procesarSecuencial(clientes, numCajeros);
        procesarConcurrente(clientes, numCajeros);
    }


    public static void procesarSecuencial(Queue<Cliente> clientes, int numCajeros) {
        System.out.println("Procesando secuencial");

        long initialTime = System.currentTimeMillis();
        //Creacion cajeros y procesarCompra
        for (int i = 1; i <= numCajeros; i++) {
            Caja nuevoCajero = new Caja(" " + i);
            nuevoCajero.procesarCompra((Cliente) clientes.toArray()[i - 1], initialTime);
        }
    }

    public static void procesarConcurrente(Queue<Cliente> clientes, int numCajeros) {
        System.out.println("Procesando Paralelo con Hilos");

        long initialTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(5);
        //Creacion de cajeros
        for (int i = 1; i <= numCajeros; i++) {
            CajaHebra nuevoCajero = new CajaHebra(" " + i,
                    (Cliente) clientes.toArray()[i - 1],
                    initialTime);
            //Arrancamos los cajeros
            executor.execute(nuevoCajero);
        }

        System.out.println("Liberando todos los hilos");
        executor.shutdown();
        executor.shutdown();
        executor.shutdown();
        executor.shutdown();
        executor.shutdown();

        // Esperamos hasta que termine
        while (!executor.isTerminated()) {
        }
        System.out.println("Todos los hilos liberados");

    }

}

