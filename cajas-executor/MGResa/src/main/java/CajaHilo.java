public class CajaHilo extends Thread {

    private String nombre;
    private Cliente cliente;
    private long initialTime;

    public CajaHilo(String nombre, Cliente cliente, long initialTime){
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    @Override
    public void run() {

        System.out.println("La caja " + this.getNombre() + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                + this.cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - this.getInitialTime()) / 1000
                + "seg");

        for (int i = 0; i< cliente.getCarro().length; i++) {
            this.esperarXsegundos(getCliente().getCarro()[i].getSegundos());
            System.out.println(this.getNombre() + " procesado el producto " + (i + 1)
                    + " del cliente " + this.getCliente().getNombre() + "->Tiempo: "
                    + (System.currentTimeMillis() - this.getInitialTime()) / 1000
                    + "seg");
        }

        System.out.println("La caja " + this.getNombre() + " HA TERMINADO DE PROCESAR "
                + this.getCliente().getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - this.getInitialTime()) / 1000
                + "seg");
    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }
}