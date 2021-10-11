import lombok.Data;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

@Data
public class Main {

    private final int CLIENT_NUMBER=8;
    private Stream<Cliente> queue =  Stream.of(new Cliente(),new Cliente(),new Cliente(), new Cliente(), new Cliente());
    private Caja office1 = new Caja(1);
    private Caja office2 = new Caja(2);

    private void startUp(){
        ExecutorService service = Executors.newCachedThreadPool();
        queue.map(a -> office1).forEach(service::execute);
        queue.map(a-> office2).forEach(service::execute);
    }

    public static void main(String[] args) {
        Main m= new Main();
        m.startUp();
    }
}
