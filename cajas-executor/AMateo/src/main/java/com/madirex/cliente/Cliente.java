package com.madirex.cliente;

import com.madirex.items.Carro;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cliente {
    private String nombre;
    private Carro carro;

}