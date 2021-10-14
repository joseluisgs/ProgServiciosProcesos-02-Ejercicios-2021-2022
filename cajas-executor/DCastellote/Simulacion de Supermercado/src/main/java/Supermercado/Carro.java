package Supermercado;
import java.util.*;
public class Carro {
    private Producto [] carroProductos;

    public Carro() {
        carroProductos = new Producto[numPro()];
        llenarCesta(carroProductos);
    }
    private void llenarCesta(Producto[] productos) {
        for (int i = 0; i < productos.length; i++) {
            Producto producto = new Producto();
            productos[i] = producto;
        }
    }
    private int numPro() {
        return (int) Math.floor((Math.random() * 30 )+ 1);
    }
    public Producto[] getCarroProductos() {
        return carroProductos;
    }

    public void setCarroProductos(Producto[] carroProductos) {
        this.carroProductos = carroProductos;
    }


}
