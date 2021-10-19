import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Carro {
    private ArrayList<Producto> productos;

    public Carro () {
        this.productos = new ArrayList<>();
        int nProductos = (int)(Math.random()*29)+1;
        for (int i = 0; i < nProductos; i++) {
            this.productos.add(new Producto(i ,(int)(Math.random()*5)+1));
        }
    }

    public ArrayList<Producto> getProductos() {
        return this.productos;
    }
}
