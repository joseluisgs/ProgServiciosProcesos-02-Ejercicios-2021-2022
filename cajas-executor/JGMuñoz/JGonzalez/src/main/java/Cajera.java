public class Cajera extends ProcesadoCaja{
    private String nombre;

    public void procesarCompra(Consumidor cliente, long timeStamp) {
        //SE MUESTRA QUE CAJERA COBRA A QUIEN Y EL TIEMPO
        System.out.println(
                "Cajera: " + this.getNombre() +
                " está cobrando a: " + cliente.getNombre() +
                " TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000	+ "SEGUNDOS");

        //EL BUCLE CUMPLE CON LOS TIEMPOS DE ESPERA Y PROCESA LOS PRODUCTOS QUE CADA CONSUMIDOR TIENE EN TIEMPO
        for (int i = 0; i< cliente.getCarro().length; i++) {
            this.espera(cliente.getCarro()[i].getSegundos());
            System.out.println(
                    this.getNombre() + " producto " + (i + 1)+" cobrado " +
                    " TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 + "SEGUNDOS");
        }
        //SE MUESTRA QUE CAJERA ACABA, CON QUIEN ACABA Y CUANTO HA TARDADO
        System.out.println("Cajera" + this.getNombre() +
                " ha terminado con " + cliente.getNombre() +
                " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 + "SEGUNDOS");

    }
        // METODOS ESPERA DE LOS HILOS Y DEMÁS GETTERS & SETTERS
    public void espera(int segundos) {
        try {
            Thread.sleep(segundos * 1250);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public Cajera(String nombre){
        super();
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}