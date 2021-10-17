package cajas;

import lombok.Data;

@Data
public class CajeraHebra {
    private Producto[] productos;

    public CajeraHebra() {
        this.productos = new Producto[(int)((Math.random()*30)+1)];
        for (int i = 0; i < productos.length; i++) {
            productos[i] = new Producto(i+1);
        }
    }
}
