public class Consumidor {
    //CLASE POJO CONSUMIDOR SIN USO DE LOMBOK
    private String nombre;
    private final Producto[] carro;

    public Consumidor(String nombre, Producto[] carro) {
        this.nombre = nombre;
        this.carro = carro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Producto[] getCarro() {
        return carro;
    }

}
