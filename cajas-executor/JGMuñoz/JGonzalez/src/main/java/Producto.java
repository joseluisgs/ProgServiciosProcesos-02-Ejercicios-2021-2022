public class Producto {
    //CLASE POJO PRODUCTO SIN USO DE LOMBOK
    private int id;
    private int segundos;

    public Producto(int id, int segundos){
        this.id = id;
        this.segundos = segundos;
    }

    public int getSegundos() {
        return segundos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;

    }
}