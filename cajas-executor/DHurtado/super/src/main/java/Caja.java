public class Caja {

    private String nombre;

    public Caja(String nombre){
        this.nombre = nombre;
    }

    public void procesarCompra(Cliente cliente, long timeStamp) {

        System.out.println("La caja " + this.getNombre() +
                " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + cliente.getNombre() +
                " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000	+
                "seg");

        for (int i = 0; i< cliente.getCarro().length; i++) {
            this.esperarXsegundos(cliente.getCarro()[i].getSegundos());
            System.out.println(this.getNombre() + " Procesado el producto " + (i + 1) +
                    " ->Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 +
                    "seg");
        }

        System.out.println("La caja " + this.getNombre() + " HA TERMINADO DE PROCESAR " +
                cliente.getNombre() + " EN EL TIEMPO: " +
                (System.currentTimeMillis() - timeStamp) / 1000 + "seg");

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
}