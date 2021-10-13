package com.madirex.caja;

import com.madirex.cliente.Cliente;
import com.madirex.items.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Caja implements Runnable{

    private Cliente cliente;
    private long initialTime;
    private String name;

    @Override
    public void run() {
        procesarCompra(cliente, initialTime); //Procesar compra
    }

    public void procesarCompra(Cliente cliente, long timeStamp) {

        System.out.println("La caja " + name +
                " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + cliente.getNombre() +
                " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000	+
                "seg");

        for (Producto p : cliente.getCarro().getProductos()) {
                this.esperarRandomProductoProceso(1, 5); //Procesar producto de 1 a 5 segundos
                System.out.println("La caja " + name + " está procesado el producto " + p.getNombre() + " del cliente " + cliente.getNombre() +
                        " ->Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 +
                        "seg");
        }



        System.out.println("La caja " + name + " HA TERMINADO DE PROCESAR " +
                cliente.getNombre() + " EN EL TIEMPO: " +
                (System.currentTimeMillis() - timeStamp) / 1000 + "seg");

    }


    private void esperarRandomProductoProceso(int minSegundos, int maxSegundos) {
        long random = (long)(maxSegundos * Math.random() + minSegundos);

        try {
            Thread.sleep(random * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
