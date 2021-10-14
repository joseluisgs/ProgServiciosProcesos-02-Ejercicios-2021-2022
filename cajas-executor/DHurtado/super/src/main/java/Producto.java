public class Producto {

    private int id;
    private int segundos;

    public Producto(int id, int segundos){
        this.id = id;
        this.segundos = segundos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
}
