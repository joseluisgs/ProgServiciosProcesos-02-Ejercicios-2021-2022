import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
JAVIER GONZALEZ MUÑOZ
Fecha fin trabajo: 18/10/2021

SITIOS DE REFERENCIA:
https://gist.github.com/godie007/6383427
https://sites.google.com/a/espe.edu.ec/programacion-ii/hilos/multitarea-e-hilos-en-java?tmpl=%2Fsystem%2Fapp%2Ftemplates%2Fprint%2F&showPrintDialog=1
https://jarroba.com/multitarea-e-hilos-en-java-con-ejemplos-ii-runnable-executors/
https://sites.google.com/a/espe.edu.ec/programacion-ii/hilos/multitarea-e-hilos-en-java (igual contenido al 2º)
 */

public class Main {
    public static void main(String[] args) {
        // SE CREAN EJEMPLOS DE PRODUCTOS ALMACENADOS EN EL "SUPERMERCADO"
        System.out.println("[][][] BIENVENIDO A IES COMERCIO PEQUEÑO [][][]");
        Producto producto1 = new Producto(1, 1);
        Producto producto2 = new Producto(2, 2);
        Producto producto3 = new Producto(3, 3);

        // SE CREAN Y ALMACENAN EN UNA COLA PARSEADOS E INTRODUCIDOS POR ARGS
        Queue<Consumidor> clientes = new LinkedList<>();
        int numCajeras= Integer.parseInt(args[0]);
        int numConsumidores = Integer.parseInt(args[1]);
        // BUCLE QUE CREA CLIENTES Y PRODUCTOS A COMPRAR
        for (int i = 1; i <= numConsumidores; i++) {
            Consumidor nuevoCliente= new Consumidor("Consumidor numero: "+ i + "ha entrado.",
                    new Producto[]{producto2, producto3, producto1, producto1, producto2, producto3});
            clientes.add(nuevoCliente);

        }
        //SE REALIZA LA FORMA SECUENCIAL Y LA FORMA CONCURRENTE CON LOS MISMOS PARAMETROS INTRODUCIDOS
        procesarCarrosSecuencial(clientes,numCajeras);
        procesarCarrosConcurrentemente(clientes,numCajeras);
    }

// FORMA SECUENCIAL
    private static void procesarCarrosSecuencial(Queue<Consumidor> clientes,int numCajeros) {
        System.out.println("[][][] SE TRABAJA SECUENCIALMENTE [][][]");
        //CONTADOR
        long initialTime = System.currentTimeMillis();
        //SE ABREN CAJEROS OPORTUNOS PARA PROCESAR LOS PRODUCTOS DE CADA CONSUMIDOR
        for (int i = 1; i <=numCajeros ; i++) {
            Cajera nuevoCajero=new Cajera("Cajero "+ i +"ABIERTO");
            nuevoCajero.procesarCompra((Consumidor) clientes.toArray()[i-1],initialTime);
        }
    }
//FORMA CONCURRENTE
    private static void procesarCarrosConcurrentemente(Queue<Consumidor> clientes, int numCajeros) {
        System.out.println("[][][] SE TRABAJA CONCURRENTEMENTE [][][]");

        //CONTADOR
        long initialTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //NUEVAMENTE ABRIMOS LOS CAJEROS OPORTUNOS Y SE PROCESAN SIENDO CRONOMETRADOS CUANDO LOS EJECUTAS (EXECUTE)
        for (int i = 1; i <=numCajeros ; i++) {
            ProcesadoCaja nuevoCajero=new ProcesadoCaja("Cajero "+ i + "ABIERTO",
                    (Consumidor) clientes.toArray()[i-1],
                    initialTime);
            executor.execute(nuevoCajero);
        }
        executor.shutdown();
        //CUANDO LOS CAJEROS HAN FINALIZADO SU EJECUCION SE MUESTRA POR PANTALLA QUE SE HA ACABADO
        while (!executor.isTerminated()) {
        }
        System.out.println("FIN DEL TRABAJO");
    }
}