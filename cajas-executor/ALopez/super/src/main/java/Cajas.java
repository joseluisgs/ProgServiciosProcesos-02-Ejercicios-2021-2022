import lombok.Data;

@Data
public class Cajas extends Thread {
    private Cliente costumer;
    private long initime;


    public Cajas(Cliente costumer, long initime) {
        this.costumer = costumer;
        this.initime = initime;


    }

    private void retardo(int seg) {
        try {
            Thread.sleep(seg * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }


    }

    @Override
    public void run() {
        System.out.println("La Cajera : " +Thread.currentThread().getName()+ " Comienza a pasar la compra del cliente : " + costumer.getIdCliente() +
                " En un tiempo de : " + (System.currentTimeMillis() - initime) / 1000 + " segundos");

        for (int i = 0; i < costumer.getCarrocompra().getProductos().length; i++) {
            // el producto se proces en seg
            this.retardo(costumer.getCarrocompra().getProductos()[i].getTiempoDeProcesado());
            System.out.println("La Cajera : " +Thread.currentThread().getName()+ " esta procesando la compra del cliente numero : "+ costumer.getIdCliente()
            +" Procesando el producto numero : "+costumer.getCarrocompra().getProductos()[i].getNumProductos()+" En un tiempo de "
                    +(System.currentTimeMillis()-initime) / 1000 + " segundos");


        }


    }


}
