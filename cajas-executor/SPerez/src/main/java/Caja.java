import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Caja implements Runnable{
    private int cajaId;
    private Clientes cola;

    @Override
    public void run() {
        while (!cola.isEmpty()) {
            Cliente clienteActual = cola.siguienteCliente();
            System.out.println("La caja " + this.cajaId + " llama al cliente " + clienteActual.getNombre());
            clienteActual.getCarroCompra().getProductos().stream().forEach(p -> {
                waitXSeconds(p.getTiempo());
                //System.out.println("La caja " + this.cajaId + " ha procesado el producto " + p.getId());
            });
            //System.out.println("La caja " + this.cajaId + " ha terminado con el cliente " + clienteActual.getNombre());
        }
    }

    private void waitXSeconds(int x) {
        try {
            Thread.sleep(x * 1000);
        }catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
