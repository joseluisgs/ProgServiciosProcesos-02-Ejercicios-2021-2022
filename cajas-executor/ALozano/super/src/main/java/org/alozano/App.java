package org.alozano;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App {


    public static void main( String[] args )
    {
        /*
        int numeroCajeras = 6;
        int numeroClientes = 8;
        if(numeroCajeras > 0 && numeroClientes > 0 ){ //Verifico que se introducen dos argumentos
        */

        int numeroCajeras = Integer.parseInt(args[0]);
        int numeroClientes = Integer.parseInt(args[1]);
        if(args.length==2 && numeroCajeras > 0 && numeroClientes > 0 ){ //Verifico que se introducen dos argumentos

            Concurrente.cajeraConcurrente(numeroCajeras, numeroClientes);
            Secuencial.cajeraSecuencial(numeroClientes);

        }else{
            System.err.println("Parámetros invalidos introduzca dos prarametros: " +
                    "siendo el primero el número de cajeras y el segundo el número de clientes");
        }

    }
}
