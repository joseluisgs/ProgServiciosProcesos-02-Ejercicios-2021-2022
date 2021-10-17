package service;

import TDA.Cola;
import model.Cliente;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Supermercado {
    static Cola colaClientesParalela;
    static Cola colaClientesSecuencial;

    // Bienvenida del programa
    public static void bienvenida() {
        System.out.println("*** Bienvenid@ a tu supermercado de confianza Nerd-Geek ***");}

    // Despedida del programa
    public static void despedida() {System.out.println("*** Esperamos que vuelvas pronto ***");}

    // Inicialización de los Clientes y se le añade a la Cola
    public static void initDatos(int numClientes) {
        Cliente clientes = null;
        colaClientesParalela = new Cola();
        colaClientesSecuencial = new Cola();
        for (int i = 0; i < numClientes; i++) {
            clientes = new Cliente("Cliente " + ( i + 1));
            colaClientesParalela.encolar(clientes);
            colaClientesSecuencial.encolar(clientes);
        }
    }

    // Ejecución de los clientes de forma paralela, se pasará como parámetro el numero de cajas que serán el número
    // de hilos y el numero de Clientes
    public static void paralelo(int numCajas, int numClientes) {

        System.out.println("Empieza el sistema en paralelo");

        long inicio = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(numCajas);
        String Caja = "Caja ";
        int i = 0;
        while(colaClientesParalela.size() > 0) {
            Runnable worker = new Caja((Cliente) colaClientesParalela.desencolar(), inicio, Caja + (i+1));
            executor.execute(worker);
            i++;
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio)/1000);
        System.out.println("La ejecución paralela duró " + tiempo + " segundos");
    }

    // Ejecución de los clientes de forma secuencial, se pasará como parámetro el número de Clientes
    public static void secuencial(int numClientes) {
        System.out.println("Empieza el sistema secuencial");

        long inicio = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(1);

        String Caja = "Caja ";
        int i = 0;
        while(colaClientesSecuencial.size() > 0) {
            Runnable worker = new Caja((Cliente) colaClientesSecuencial.desencolar(), inicio, Caja + (i+1));
            executor.execute(worker);
            i++;
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio)/1000);
        System.out.println("La ejecución secuencial duró " + tiempo + " segundos");
    }
}
