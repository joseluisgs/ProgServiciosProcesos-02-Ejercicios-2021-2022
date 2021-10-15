package cajas;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cajera {
    private String nombre;

    public void procesarCompra(Cliente client, long timestamp){
        System.out.println("La cajera "+ getNombre()+
                " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                + client.getNumCliente() + " EN EL TIEMPO: " +
                (System.currentTimeMillis() - timestamp)/1000 + "seg");
        for (int i = 0; i<client.getCarroCompra().getProductos().length; i++){
            this.esperarXsegundos(client.getCarroCompra().getProductos()[i].getTiempoEnProcesar());
            System.out.println(("cajera"+getNombre() + " con cliente "+client.getNumCliente()+
                    " producto " + client.getCarroCompra().getProductos()[i].getNumProducto()
                    + " -> Tiempo: " + (System.currentTimeMillis() - timestamp)/1000 + "seg"));
        }
        System.out.println("La cajera " + this.getNombre() + " HA TERMINADO DE PROCESAR " +
                client.getNumCliente() + " EN EL TIEMPO: "+
                (System.currentTimeMillis() - timestamp)/1000 + "seg");
    }


    public void esperarXsegundos(int seconds){
        try{
            Thread.sleep(seconds * 1000);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
}