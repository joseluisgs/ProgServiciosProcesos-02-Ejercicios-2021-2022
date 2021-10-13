package com.madirex;

public class App {
    public static void main(String[] args) {
        int nCajas;
        int nClientes;

        //Asignar cajas y clientes por parámetros
            //(En el caso de que no se pasen los parámetros, se asignan 4 cajas, 20 clientes)
        try {
            nCajas = Integer.parseInt(args[0]);
            nClientes = Integer.parseInt(args[1]);

            System.out.println("Se han establecido " + nCajas + " cajas y " + nClientes + " clientes.");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Debes de establecer los parámetros:" +
                    "\nnúmero de cajas" +
                    "\nnúmero de clientes" +
                    "\n");
            System.out.println("Como no has establecido los parámetros correctamente, " +
                    "\npondré por defecto 4 cajas y 2 clientes");

            nCajas = 4;
            nClientes = 2;
        }

        //Ejecución del programa
        Supermercado sup = new Supermercado(nClientes, nCajas);

        //sup.imprimirArray();
        long secuencialTime = sup.procesarCarrosSecuencialmente();
        long concurrenteTime = sup.procesarCarrosConcurrentemente();

        if (secuencialTime - concurrenteTime > 0) {
            System.out.println("Los carros se han procesado " + (secuencialTime - concurrenteTime) +
                    " segundos más rápido con la programación concurrente.");
        }

    }
}
