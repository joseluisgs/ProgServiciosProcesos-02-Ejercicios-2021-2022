package org.andrea;

import lombok.Data;

import java.util.ArrayDeque;

@Data
public class Caja implements Runnable {

    private Cliente cliente;
    private String nombreCliente;
    private String nombreCaja;
    private long inicioTiempo;
    private long tiempoTotal = System.currentTimeMillis() - inicioTiempo;


    public Caja(Cliente cliente, String nombreCliente, String nombreCaja) {
        this.cliente = cliente;
        this.nombreCliente = nombreCliente;
        this.nombreCaja = nombreCaja;


    }

    public Caja() {
    }

    //Mostrará el tiempo de vida de la compra en caja de cada cliente.
    //De forma adicional se implementa un informador del tiempo de proceso de cada producto.
    @Override
    public void run() {

        procesarCompra();

    }

    public void procesarCompra() {

        inicioTiempo = System.currentTimeMillis();

        System.out.println("SE EMPIEZA A PROCESAR LA COMPRA DEL CLIENTE -->: " + cliente.getNombreCliente() +
                "\nInicio de tiempo: " + inicioTiempo + " segundos");


        for (int i = 0; i < cliente.getCarro().getProductos().length; i++) {
            esperaSegundos(cliente.getCarro().getProductos()[i].getTiempoEnProcesar());
            System.out.println("Pasando producto " + cliente.getCarro().getProductos()[i].getIdProducto() + " del cliente: " + cliente.getNombreCliente());

        }

        System.out.println("***SE HA TERMINADO DE ATENDER AL CLIENTE: " + cliente.getNombreCliente());
        System.out.println("TIEMPO TARDADO:" + (System.currentTimeMillis() - inicioTiempo));

    }


    public void esperaSegundos(long segundos) {
        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


}
