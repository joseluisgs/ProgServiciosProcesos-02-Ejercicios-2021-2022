import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        Clientes clientes = new Clientes(Integer.parseInt(args[1]));
        long concurrentTime = procesamientoConPool(Integer.parseInt(args[0]), clientes);
        clientes.resetClientes();
        long sequentialTime = procesamientoSinPool(clientes);
        System.out.println("Total concurrent time: " + concurrentTime);
        System.out.println("Total sequential time: " + sequentialTime);
    }

    private static long procesamientoSinPool (Clientes clientes) {
        long start = System.currentTimeMillis();
        Caja caja = new Caja(0, clientes);
        caja.run();
        return System.currentTimeMillis() - start;
    }
    private static long procesamientoConPool(int numCajas, Clientes clientes) {
        long start = System.currentTimeMillis();
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(numCajas);
        for (int i = 0; i < numCajas; i++) {
            threadPool.execute(new Caja(i, clientes));
        }
        threadPool.shutdown();
        while (!threadPool.isTerminated())
        {
            try{
                Thread.sleep(1);
            }catch (InterruptedException ex) {
                System.out.println("uwu");
            }
        }
        return System.currentTimeMillis() - start;
    }
}
