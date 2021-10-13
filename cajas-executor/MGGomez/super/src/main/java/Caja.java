public class Caja extends Thread {
    Servicios serv = new Servicios();
    private long initialTime;

    private Clientela clientela = Clientela.generarClientela(Clientela.numClientes);

    public Caja() {

    }

    @Override
    public void run() {

        for (int i = 0; i < Clientela.getClientes().size(); i++) {
            Cliente clienteActual = clientela.desencolar();
            for (int k = 0; k < clienteActual.getCarro().getProductos().length; k++) {
                initialTime = System.currentTimeMillis();
                serv.esperarXsegundos(clienteActual.getCarro().getProductos()[k].getTiempoProceso());

                System.out.println("El pool está procesado el producto " + (k + 1)
                        + " del cliente " + clienteActual.getId() + "->Tiempo: "
                        + (System.currentTimeMillis() - this.getInitialTime()) / 1000
                        + "seg");
            }
        }
    }


    public Servicios getServ() {
        return serv;
    }

    public void setServ(Servicios serv) {
        this.serv = serv;
    }

    public long getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }
}
