package ejercicio.CajasColas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class CarritoCompra {

    int product = (int) ((Math.random() * 30) + 1);
    private Producto[] productos = new Producto[product];

    public CarritoCompra() {
        for (int i = 0; i < productos.length; i++) {
            Producto producto = new Producto();
            // productos[i] = new Producto(i+1);
            productos[i] = producto;
        }
    }
}
