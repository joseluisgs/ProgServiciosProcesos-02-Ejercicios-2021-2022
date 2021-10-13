package org.alozano;

import lombok.Data;

@Data
public class Cajera implements Runnable {
    private Cliente cliente;
    private long initialTime;

    public Cajera(Cliente cliente, long initialTime){
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    @Override
    public void run() {

        System.out.println("La cajera: " + Thread.currentThread().getName() + " Comienza procesando la compra del cliente: " + cliente.getNumCliente()
                + " En el tiempo: " + (System.currentTimeMillis() - initialTime) / 1000 + " seg");

        for (int i = 0; i < cliente.getCarro().getProductos().length; i++) {
            // Se procesa el producto en segundos
            this.tiempoEspera(cliente.getCarro().getProductos()[i].getTiempoProcesamiento());
            System.out.println("La cajera: " + Thread.currentThread().getName() + " Procesa la compra del cliente: " + cliente.getNumCliente()
                    +" Procesa el producto: " + cliente.getCarro().getProductos()[i].getNumProductos()+
                    " En el tiempo: " + (System.currentTimeMillis() - initialTime) / 1000 + " seg");
        }

        System.out.println("La cajera: " + Thread.currentThread().getName() + " Ha terminado de procesar la compra del cliente " + cliente.getNumCliente()
                + " En el tiempo: " + (System.currentTimeMillis() - initialTime) / 1000 + "seg");

    }

    private void tiempoEspera(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}

