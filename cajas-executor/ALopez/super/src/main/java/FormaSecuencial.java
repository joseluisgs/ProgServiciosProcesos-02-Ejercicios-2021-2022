import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FormaSecuencial {

    public static void cajasSecuencial(int numCostumers){

        // comentamos para que se sepa cuando empieza de forma secuencial y ponemos el initialtime
        System.out.println("Se inicia de forma  Secuencial");
        long initialTime = System.currentTimeMillis();

        ClientesCola costumers = new ClientesCola(numCostumers);

        for(int i =0; i<numCostumers;i++){
            Runnable cajerosactivos = new Cajas(costumers.getClientesCola().pop(),initialTime);
          cajerosactivos.run();

        }

        long finaltime= System.currentTimeMillis(); //tiempo final del proceso
        System.out.println("El tiempo final de procesamiento es de "+(finaltime-initialTime)/1000+" seg. ");
        System.out.println("Se ha terminado el programa que se ejecutaba de forma Secuencial");




    }


    }

