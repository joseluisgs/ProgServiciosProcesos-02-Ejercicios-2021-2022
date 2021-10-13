public class Carro {
    private Producto[] productos;

    public Carro() {
        productos = new Producto[numProductos()];
        llenarCesta(productos);
    }

    private int numProductos() {
        return (int) Math.floor((Math.random() * 30 )+ 1);
    }

    private void llenarCesta(Producto[] productos) {
        for (int i = 0; i < productos.length; i++) {
            Producto producto = new Producto();
            productos[i] = producto;
        }
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }
}
