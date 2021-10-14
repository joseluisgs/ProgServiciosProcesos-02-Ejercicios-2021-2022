package Supermercado;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Caja extends Thread{
    private String nombre;
    private Cliente cliente;
    private long initialTime;
    private Caja caja;

    private Clientes clientes = Clientes.generarClientes(Clientes.numClientes);
    public Caja(){}
    @Override
    public void run() {

        for (int i = 0; i < Clientes.getClientesLista().size(); i++) {
            Cliente clienteActual = clientes.desencolar();
            for (int k = 0; k < clienteActual.getCarrito().getCarroProductos().length; k++) {
                initialTime = System.currentTimeMillis();
                caja.esperarXsegundos(clienteActual.getCarrito().getCarroProductos()[k].getTiempoProceso());

                System.out.println("El pool está procesado el producto " + (k + 1)
                        + " del cliente " + clienteActual.getId() + "->Tiempo: "
                        + (System.currentTimeMillis() - this.getInitialTime()) / 1000
                        + "seg");
            }
        }
    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
