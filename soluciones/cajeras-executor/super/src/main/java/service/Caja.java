package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import model.Cliente;
import model.Producto;

@Data
@AllArgsConstructor
public class Caja implements Runnable {
    private Cliente cliente;
    private long timeStamp;
    private String nombre;


    // Servicio información tiempos y procesos de la compra
    public void run() {
        System.out.println("LA CAJA " + this.getNombre() +
                " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + cliente.getNombre() +
                " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000	+
                "seg");

        for (int i = 0; i< cliente.getCarro().getProductos().length; i++) {
            this.esperarXsegundos(cliente.getCarro().getProductos()[i]);
            System.out.println(" Procesado el producto " + (i + 1) + " Del cliente : " + cliente.getNombre() +
                    " ->Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 +
                    "seg");
        }

        System.out.println("SE HA TERMINADO DE PROCESAR " +
                cliente.getNombre() + " EN EL TIEMPO: " +
                (System.currentTimeMillis() - timeStamp) / 1000 + "seg");

    }
    // Hacer esperar X segundos por cada producto
    private void esperarXsegundos(Producto segundos) {
        try {
            Thread.sleep(segundos.getSegundos() * 1000L);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
