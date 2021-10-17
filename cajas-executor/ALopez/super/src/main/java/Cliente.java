import lombok.Data;


@Data

public class Cliente {
    //Creamos el cliente que tiene un id con el cual sabremos que cliente es
    //y tiene un carro de compra que esta formado por productos
    private int idCliente;
    private Carro carrocompra;

    public Cliente(int idCliente){

        this.idCliente= idCliente;
        this.carrocompra= new Carro();

    }

}
