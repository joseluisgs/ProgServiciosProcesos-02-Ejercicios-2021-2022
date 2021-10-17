import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Servicios serv = new Servicios();
        Scanner sc = new Scanner(System.in);
        long initialTime;
        int numClientes;
        int numCajas;
        Cajas cajas;
        System.out.println("Introduce el número de Clientes totales");
        numClientes = sc.nextInt();
        Clientela.generarClientela(numClientes);


        System.out.println("Introduce ahora el número de cajas operativas");
        numCajas = sc.nextInt();
        cajas = new Cajas(numCajas);
        initialTime= System.currentTimeMillis();
        serv.procesarCajas(cajas);
        System.out.println("La operación ha tardado un total de " + ((System.currentTimeMillis()-initialTime)/1000) +" segundos");
    }
}
