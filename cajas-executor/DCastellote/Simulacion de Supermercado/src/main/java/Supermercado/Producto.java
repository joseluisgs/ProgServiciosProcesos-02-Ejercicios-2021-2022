package Supermercado;

import java.util.Random;

public class Producto {

    private int tiempoProceso;

    public Producto() {

        tiempoProceso = tiempoDeProceso();
    }

    private int tiempoDeProceso(){
        return (int) Math.floor((Math.random() * 5) + 1);
}
    public int getTiempoProceso() {
        return tiempoProceso;
    }

    public void setTiempoProceso(int tiempoProceso) {
        this.tiempoProceso = tiempoProceso;
    }
}
