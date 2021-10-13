public class Cliente {
    Carro carro;
    public static int  contador=1;
    int id;

    public Cliente() {
        carro = new Carro();
        id= Cliente.contador++;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
