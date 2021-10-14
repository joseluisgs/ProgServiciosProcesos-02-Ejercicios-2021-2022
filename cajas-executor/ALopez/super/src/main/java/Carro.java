import lombok.Data;

import java.util.Random;

@Data

public class Carro {
    //El carro esta formado por un array de productos
    //como vemos hay de 1 a 30 productos dentro de un carro
    private Producto[] productos;

    public Carro() {

        this.productos = new Producto[new Random().nextInt(30)+1];
        for (int i = 0; i < productos.length; i++) {
            productos[i] = new Producto(i + 1);
        }
    }

}
