import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {



    public static void main(String[] args) {

        Producto pr1 = new Producto(1, 1);
        Producto pr2 = new Producto(2, 2);
        Producto pr3 = new Producto(3, 3);
        Producto pr4 = new Producto(4, 4);
        Producto pr5 = new Producto(5, 5);


        Queue<Cliente> clientes = new LinkedList<>();
        //Variables pasadas por parametro en args
        int numCajeros= Integer.parseInt(args[0]);
        int numClientes = Integer.parseInt(args[1]);
        //Crea los Clientes y los añade a la queue clientes
        for (int i = 1; i <= numClientes; i++) {
            Cliente nuevoCliente= new Cliente("Cliente "+ i,
                    new Producto[]{pr3, pr2, pr5, pr1, pr1, pr4});
            clientes.add(nuevoCliente);

        }

        procesarCarrosSecuencial(clientes,numCajeros);
        procesarCarrosConcurrentemente(clientes,numCajeros);
    }


    private static void procesarCarrosSecuencial(Queue<Cliente> clientes,int numCajeros) {
        System.out.println("Procesando secuencial");


        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        //Creacion cajeros y procesarCompra
        for (int i = 1; i <=numCajeros ; i++) {
            Caja nuevoCajero=new Caja("Cajero "+ i);
            nuevoCajero.procesarCompra((Cliente) clientes.toArray()[i-1],initialTime);
        }

        }

    private static void procesarCarrosConcurrentemente(Queue<Cliente> clientes,int numCajeros) {
        System.out.println("Procesando Paralelo con Hilos");


        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        //en el for se crea los cajeros y el ejecutor los pone en marcha
        for (int i = 1; i <=numCajeros ; i++) {
            CajaHilo nuevoCajero=new CajaHilo("Cajero "+ i,
                    (Cliente) clientes.toArray()[i-1],
                    initialTime);
            executor.execute(nuevoCajero);
        }

        executor.shutdown();
        // Esperamos hasta que termine
        while (!executor.isTerminated()) {
        }
        System.out.println("Han terminado todos los hilos");

}
}