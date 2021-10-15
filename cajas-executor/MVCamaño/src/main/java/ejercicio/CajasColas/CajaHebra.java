package ejercicio.CajasColas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CajaHebra extends Thread {
    private String nombre;
    private Cliente cliente;
    private long initialTime;
    private CarritoCompra carritoCompra = new CarritoCompra();


    @Override
    public void run() {

        System.out.println("La caja nº " + this.getNombre() +
                " comienza a atender al cliente  " + cliente.getNombre() +
                " en el transcurso de : " + (System.currentTimeMillis() - initialTime) / 1000 +
                "seg");

        for (int i = 0; i < carritoCompra.getProductos().length; i++) {
            this.esperarXsegundos(carritoCompra.getProductos()[i].getTiempoProceso());
            System.out.println("La caja nº " + nombre + " está escaneando el producto " + (i + 1) + " del cliente " + cliente.getNombre() +
                    " ->Tiempo: " + (System.currentTimeMillis() - initialTime) / 1000 +
                    "seg");
        }

        System.out.println("La caja nº " + this.getNombre() + " ha finalizado de atender al " +
                cliente.getNombre() + " en el tiempo de : " +
                (System.currentTimeMillis() - initialTime) / 1000 + "seg");

    }

    public void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }

    public CajaHebra(String s, Cliente cliente, long initialTime) {
        this.nombre = s;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }
}
