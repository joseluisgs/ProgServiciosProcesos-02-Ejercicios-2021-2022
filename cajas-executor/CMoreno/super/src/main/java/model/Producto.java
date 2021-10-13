package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
public class Producto {
    static final int MAX_TIEMPO = 5;
    private int segundos;

    Producto() {
        segundos = new Random().nextInt(MAX_TIEMPO) + 1;
    }
}