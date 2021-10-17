package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Carrito {
    private final int PRODUCO_MAX = 30;
    private final int random = (int) ((Math.random() * PRODUCO_MAX) + 1);
    private Producto[] objetos = new Producto[random];

    public Carrito() {
        for (int i = 0; i < random; i++) {
            objetos[i] = new Producto(i + 1);
        }
    }
}