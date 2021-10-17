package cajas;

import lombok.Data;

@Data
public class CajeraHebras extends Thread {
    private String nombre;
    private Cliente cliente;
    private long initialTime;


    // El metodo concurrente a ejecutar por una hebra siempre se llama run
    // si te fijas es el procesar compra de CajeraHebra
    @Override
    public void run(){
        System.out.println("La cajera "+this.nombre +
                " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + cliente.getNumCliente() +
                " EN EL TIEMPO: " + (System.currentTimeMillis() - initialTime)/1000 + "seg");
        for (int i = 0; i < cliente.getCarroCompra().getProductos().length; i++){
            this.esperarXsegundos(cliente.getCarroCompra().getProductos()[i].getTiempoEnProcesar());
            System.out.println((this.nombre + " Procesando el cliente "+
                    cliente.getNumCliente()+" producto " +
                    cliente.getCarroCompra().getProductos()[i].getNumProducto() + " -> Tiempo: " + (System.currentTimeMillis() - initialTime)/1000 + "sec"));
        }
        System.out.println("La cajera " + this.nombre + " HA TERMINADO DE PROCESAR "
                + cliente.getNumCliente() + " EN EL TIEMPO: "+ (System.currentTimeMillis() - initialTime)/1000 + "seg");
    }
    public CajeraHebras(String checkOutName, Cliente client, long initialTime){
        this.nombre = checkOutName;
        this.cliente = client;
        this.initialTime = initialTime;
    }
    public void esperarXsegundos(int segundos){
        try{
            Thread.sleep(segundos * 1000);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }

}
