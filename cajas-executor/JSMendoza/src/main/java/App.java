import model.Clientes;
import service.CajaConcurrente;
import service.CajaSecuencial;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        try {
            int cajas = Integer.parseInt(args[0]);
            int clientes = Integer.parseInt(args[1]);
            if ((cajas > 0) && (clientes > 0)) {
                int tiempoSecuencial = secuencial(cajas, clientes);
                int tiempoConcurrente = concurrente(cajas, clientes);
                System.out.println("Procesamiento secuencial terminado en " + tiempoSecuencial + " segundos.");
                System.out.println("Procesamiento concurrente terminado en " + tiempoConcurrente + " segundos.");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + "\n Wrong Arguments has been passed");
        }
    }

    private static int secuencial(int cajas, int clientes) {
        Clientes cliente = new Clientes(clientes);
        long tiempoInicial = System.currentTimeMillis();
        CajaSecuencial[] cajaSecu = new CajaSecuencial[cajas];
        while (!cliente.getClientQueue().isEmpty()) {
            for (int i = 0; i < cajas; i++) {
                cajaSecu[i] = new CajaSecuencial();
                cajaSecu[i].procesarCompra(cliente.getClientQueue().pop(), tiempoInicial);
            }
        }
        return (int) ((System.currentTimeMillis() - tiempoInicial) / 1000);
    }

    private static int concurrente(int cajas, int clientes) {
        Clientes cliente = new Clientes(clientes);
        long tiempoInicial = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(cajas);
        CajaConcurrente[] cajaConcu = new CajaConcurrente[cajas];
        for (int i = 0; i < cajas; i++) {
            cajaConcu[i] = new CajaConcurrente();
            executor.execute(cajaConcu[i]);
        }
        executor.shutdown();
        while (true) {
            if (executor.isTerminated()) break;
        }
        return (int) ((System.currentTimeMillis() - tiempoInicial) / 1000);
    }
}
