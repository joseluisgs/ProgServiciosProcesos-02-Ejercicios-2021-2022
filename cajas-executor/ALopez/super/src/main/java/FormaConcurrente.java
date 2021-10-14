import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FormaConcurrente {
    public static void cajasConcurrentes(int numCajas,int numCostumers){

     // comentamos para que se sepa cuando empieza de forma concurrente y ponemos el initialtime
        System.out.println("Se inicia de forma Concurrente");
        long initialTime = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(numCajas);
        ClientesCola costumers = new ClientesCola(numCostumers);

        for(int i =0; i<numCostumers;i++){
            Runnable cajerosactivos = new Cajas(costumers.getClientesCola().pop(),initialTime);
            executorService.execute(cajerosactivos);

        }
        //apagamos el executor para que espere a que se terminen de ejecutar los demas procesos y no ejecute los siguientes
        executorService.shutdown();
        while(!executorService.isTerminated()){

        }
        long finaltime= System.currentTimeMillis(); //tiempo final del proceso
        System.out.println("El tiempo final de procesamiento es de "+(finaltime-initialTime)/1000+" seg. ");
        System.out.println("Se ha terminado el programa que se ejecutaba de forma recurrente");

        //el metodo concurrente es mas dificil que el secuencial ya que el secuencial es solo un hilo
        // y este necesita executor


    }
}
