package model;

import lombok.Data;

@Data
public class Cliente {
    private String nombre;
    private Carro carro;

    public Cliente(String nombre) {
        this.nombre = nombre;
        carro = new Carro();
    }
}