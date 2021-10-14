import lombok.Data;

import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
public class Main {

    private ArrayDeque<Cliente> queue =  new ArrayDeque<Cliente>();

    private void startUp(){
        addClients();
        ExecutorService service = Executors.newFixedThreadPool(2);
        int numero=1;

        while(!queue.isEmpty()){
            Caja c1 = new Caja(queue.getFirst(),numero);
            queue.removeFirst();
            numero+=1;
        }
    }

    public static void main(String[] args) {
        Main m= new Main();
        m.startUp();
    }

    private void addClients(){
       queue.add(new Cliente());
       queue.add(new Cliente());
       queue.add(new Cliente());
       queue.add(new Cliente());
       queue.add(new Cliente());
    }
}
