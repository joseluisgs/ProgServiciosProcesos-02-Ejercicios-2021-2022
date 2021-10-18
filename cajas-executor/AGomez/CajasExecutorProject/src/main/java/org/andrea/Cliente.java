package org.andrea;
import lombok.Data;



@Data
public class Cliente {

    private String nombreCliente;
    private Carro carro;

    public Cliente(String nombreCliente){

        this.nombreCliente= nombreCliente;
        this.carro= new Carro();


    }

}
