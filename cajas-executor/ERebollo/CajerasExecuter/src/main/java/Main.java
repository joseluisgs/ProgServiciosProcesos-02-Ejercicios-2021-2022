import lombok.Data;

import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
public class Main {

    private static ArrayDeque<Cliente> queue;
    private static Caja[] cajas;
    private static Long totalTimeSecuencial;
    private static Long totalTimeConcurrente;

    public static void startUp(int clientes, int numCajas){
        queue = new Clientes(clientes).getClientes();

        long initialTime = System.currentTimeMillis();

        startUpSecuencial(clientes,numCajas,initialTime);
        startUpConcurrente(clientes,numCajas,initialTime);
    }

    private static void startUpSecuencial(int clientes, int numCajas, long initialTime){

        cajas = new Caja[numCajas];

        while(!queue.isEmpty()){
            for(int i=0;i<numCajas;i++){
                if(!queue.isEmpty()){
                    cajas[i]=new Caja(queue.getFirst(),i);
                    queue.removeFirst();
                    cajas[i].run();
                }
            }
        }
        totalTimeSecuencial = (System.currentTimeMillis()-initialTime)/1_000;
    }

    private static void startUpConcurrente(int numeroClientes, int hilos, long initialTime){

        ExecutorService service = Executors.newFixedThreadPool(hilos);
        int numero=1;

        while(!queue.isEmpty()){
            Caja c = new Caja(queue.getFirst(),numero);
            service.execute(c);
            queue.removeFirst();
            numero+=1;
        }

        service.shutdown();
        totalTimeConcurrente = (System.currentTimeMillis()-initialTime)/1_000;
    }

    public static void main(String[] args) {
        try {
            final int HILOS = Integer.parseInt(args[0]);
            final int CLIENTES = Integer.parseInt(args[1]);

            startUp(CLIENTES, HILOS);
            System.out.println("Tiempo necesario de forma secuencial: "+totalTimeSecuencial);
            System.out.println("Tiempo necesario de forma concurrente: "+totalTimeConcurrente);

        }catch(NumberFormatException e){
            System.out.println("Parametros no validos");
        }
    }
}
