package service;

import lombok.Data;
import model.Cliente;

@Data
public class CajaSecuencial {
    private String nombre = "Caja secuencial";
    private Cliente cliente;

    public void procesarCompra(Cliente cliente, long tiempoInicial) {
        System.out.println(this.getNombre() + " comienza a procesar la compra del cliente " +
                cliente.getNumClientes() + " en el tiempo: " + (System.currentTimeMillis() - tiempoInicial) / 1000 +
                " seg." + " Número de productos: " + cliente.getCarritos().getObjetos().length);
        for (int i = 0; i < cliente.getCarritos().getObjetos().length; i++) {
            this.tiempoEspera(cliente.getCarritos().getObjetos()[i].getTiempoProcesamiento());
            System.out.println((getNombre() + " Procesando al cliente " + cliente.getNumClientes() + " producto " +
                    cliente.getCarritos().getObjetos()[i].getNumProductos() + " -> Tiempo: " +
                    (System.currentTimeMillis() - tiempoInicial) / 1000 + " seg."));
        }
        System.out.println(getNombre() + " ha terminado de procesar los productos del cliente" +
                " " +
                cliente.getNumClientes() + " en el tiempo de " + (System.currentTimeMillis() - tiempoInicial) / 1000 +
                " seg.");
    }

    public void tiempoEspera(int segundos) {
        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
