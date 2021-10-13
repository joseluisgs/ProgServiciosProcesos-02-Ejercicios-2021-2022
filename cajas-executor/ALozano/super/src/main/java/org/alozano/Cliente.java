package org.alozano;

import lombok.*;

@Data
@NoArgsConstructor
public class Cliente {
    private int numCliente;
    private Carro carro;

    public Cliente(int numCliente){
        this.numCliente = numCliente;
        this.carro = new Carro();
    }
}
