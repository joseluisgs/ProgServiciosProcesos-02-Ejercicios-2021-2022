package Supermercado;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Super {
    public static void main(String[] args) {
        Caja caja= new Caja();
        Cajas cajas;

        cajas = new Cajas(2);
        Clientes.generarClientes(4);

        long initialTime = System.currentTimeMillis();
        caja.procesarCajas(cajas);
        System.out.println("La operación ha tardado un total de " + ((System.currentTimeMillis()-initialTime)/1000) +" segundos");
    }






}
