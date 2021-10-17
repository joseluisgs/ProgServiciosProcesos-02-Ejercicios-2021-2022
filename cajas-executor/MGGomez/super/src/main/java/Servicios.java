import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servicios {

    public void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void procesarCajas(Cajas cajas) {
        System.out.println("Procesando el Pool");
        ExecutorService executor = Executors.newFixedThreadPool(cajas.getCajas().length);
        for (int i = 0; i < cajas.getCajas().length; i++) {
            executor.execute(cajas.getCajas()[i]);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Han terminado todos los hilos");
    }
}
