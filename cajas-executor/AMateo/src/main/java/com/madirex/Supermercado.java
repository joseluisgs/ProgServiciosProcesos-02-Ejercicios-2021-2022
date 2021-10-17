package com.madirex;

import com.madirex.caja.Caja;
import com.madirex.cliente.Cliente;
import com.madirex.cliente.Clientes;
import com.madirex.items.Carro;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
@AllArgsConstructor
public class Supermercado {
    private int numClientes;
    private int numCajas;

    /**
     * Procesar carros concurrentemente
     */
    public long procesarCarrosConcurrentemente() {

        System.out.println("Procesando en paralelo con Pool");

        //Agregar clientes
        Clientes clientes = new Clientes(this.numClientes);

        for(int n = 0; n < this.numClientes; n++){
            clientes.entrar(new Cliente("Cliente " + (n + 1), new Carro()));
        }

        // Crear pool de hilos (las cajas disponibles), y meter el siguiente una vez termine uno de ellos
        ExecutorService executor = Executors.newFixedThreadPool(numCajas);

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();


        for (int n = 0; n < numCajas; n++) {
            if (!clientes.isEmpty()) {
                Runnable worker = new Caja(clientes.getFirst(), initialTime, "Caja " + (n + 1));
                executor.execute(worker);
                clientes.salir();
            }else{
                break;
            }
        }

        executor.shutdown();

        // Esperamos hasta que termine
        while (!executor.isTerminated()) {
        }

        //Tiempo final de referencia
        long finalTime = System.currentTimeMillis();

        System.out.println("Han terminado todos los hilos.");

        long segundosTotal = (finalTime - initialTime) / 1000;
        System.out.println("El proceso de carros concurrente ha finalizado en "
                + segundosTotal +" segundos.");

        return segundosTotal;
    }

    /**
     * Procesar carros secuencialmente
     */
    public long procesarCarrosSecuencialmente() {
        System.out.println("Procesando Paralelo con Hilos");

        //Agregar clientes
        Clientes clientes = new Clientes(this.numClientes);

        for(int n = 0; n < this.numClientes; n++){
            clientes.entrar(new Cliente("Cliente " + (n + 1), new Carro()));
        }

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();

        for (int n = 0; n < numCajas; n++) {
            if (!clientes.isEmpty()) {
                Caja caja = new Caja(clientes.getFirst(), initialTime, "Caja " + (n + 1));
                caja.procesarCompra(caja.getCliente(), initialTime);
                clientes.salir();
            }
            else{
                break;
            }
        }

        //Tiempo final de referencia
        long finalTime = System.currentTimeMillis();

        System.out.println("Han terminado todos los hilos.");

        long segundosTotal = (finalTime - initialTime) / 1000;
        System.out.println("El proceso de carros secuencial ha finalizado en "
                + segundosTotal + " segundos.");

        return segundosTotal;
    }
}