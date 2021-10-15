package cajas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {

        try {
            int numThreads = Integer.parseInt(args[0]);
            int numClientes = Integer.parseInt(args[1]);
            if((numThreads>0)&&(numClientes>0)) {
                int finSecuencial = procesarCarrosSecuencialmente(numThreads,numClientes);
                int finConcurrente = procesarCarrosConcurrentemente(numThreads,numClientes);
                System.out.println("Fin secuencial en "+finSecuencial+" segundos.");
                System.out.println("Fin concurrente en "+finConcurrente+" segundos.");
            }
        } catch(ArrayIndexOutOfBoundsException ae){
            System.out.println("Tienes que poner el numero de cajeras y de clientes");
        } catch(NumberFormatException e){
            System.out.println(e.getMessage() + "\n error de formato");}
    }
    private static int procesarCarrosConcurrentemente(int numThreads, int numClients){
        System.out.println("Hilos proceso concurrente "+ numThreads );
        Clientes clients = new Clientes(numClients);
        long initialTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        CajeraHebras[] checkOutThreads = new CajeraHebras[numThreads];
        while (!clients.getColaClientes().isEmpty()) {
            for (int i = 0; i< numThreads ;i++) {
                checkOutThreads[i] = new CajeraHebras(""+(i+1),clients.getColaClientes().pop(), initialTime);
                executor.execute(checkOutThreads[i]);
            }
        }
        executor.shutdown();
        while (!executor.isTerminated()){}

        System.out.println("Fin de compras");
        return (int)((System.currentTimeMillis()-initialTime)/1000);
    }
    private static int procesarCarrosSecuencialmente(int numThreads, int numClients){
        System.out.println("Proceso secuencial con Pool de "+ numThreads + " Cajerass:");
        Clientes clients = new Clientes(numClients);
        Cajera[] checkOuts = new Cajera[numThreads];
        long initialTime = System.currentTimeMillis();
        while (!clients.getColaClientes().isEmpty()){
            for (int i=0;i<numThreads;i++) {
                checkOuts[i] = new Cajera(""+(i+1));
                checkOuts[i].procesarCompra(clients.getColaClientes().pop(), initialTime);
            }
        }
        System.out.println("Fin de las compras");
        return (int)((System.currentTimeMillis()-initialTime)/1000);
    }

}
