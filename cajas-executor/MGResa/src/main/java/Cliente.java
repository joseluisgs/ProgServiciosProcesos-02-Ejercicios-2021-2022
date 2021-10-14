public class Cliente {

    private String nombre;
    private Producto[] carro;


    public Cliente(String nombre, Producto[] carro) {
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
