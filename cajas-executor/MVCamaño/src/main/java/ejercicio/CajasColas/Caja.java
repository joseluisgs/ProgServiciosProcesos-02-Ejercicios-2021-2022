package ejercicio.CajasColas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Caja {
    String nombre;
    CarritoCompra carritoCompra = new CarritoCompra();


    public void procesarCompra(Cliente cliente, long timeStamp) {

        System.out.println("La caja  " + this.getNombre() +
                " comienza a atender al cliente  " + cliente.getNombre() +
                " en el transcurso de : " + (System.currentTimeMillis() - timeStamp) / 1000 +
                "seg");

        for (int i = 0; i < carritoCompra.getProductos().length; i++) {
            this.esperarXsegundos(carritoCompra.getProductos()[i].getTiempoProceso());
            System.out.println("La caja nº " + nombre + " está procesando el producto " + (i + 1) + " del cliente " + cliente.getNombre() +
                    " ->Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 +
                    "seg");
        }

        System.out.println("La caja nº " + this.getNombre() + " ha terminado de atender al " +
                cliente.getNombre() + " en el tiempo de : " +
                (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
    }

    public void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public Caja(String s) {
        this.nombre = s;
    }

}
