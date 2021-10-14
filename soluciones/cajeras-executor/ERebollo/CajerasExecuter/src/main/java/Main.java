import lombok.Data;

import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
public class Main {

    private static ArrayDeque<Cliente> queue =  new ArrayDeque<Cliente>();

    private static void startUp(int numeroClientes, int hilos){
        addClients(numeroClientes);
        ExecutorService service = Executors.newFixedThreadPool(hilos);
        int numero=1;

        while(!queue.isEmpty()){
            Caja c = new Caja(queue.getFirst(),numero);
            service.execute(c);
            queue.removeFirst();
            numero+=1;
        }

        service.shutdown();
    }

    private static void addClients(int numeroClientes){
       for(int i=0;i<numeroClientes;i++){
           queue.add(new Cliente(i));
       }
    }

    public static void main(String[] args) {
        final int HILOS = Integer.parseInt(args[0]);
        final int CLIENTES = Integer.parseInt(args[1]);

        startUp(CLIENTES, HILOS);
    }
}
