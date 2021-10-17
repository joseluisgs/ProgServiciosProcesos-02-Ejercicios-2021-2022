package Supermercado;

import java.util.*;

public class Cliente {
    private String nombre;
    //private Carro carrito;
    private Carro carrito;
    public static int  contador=1;
    int id;


    //ArrayList<Cliente> clientes =new ArrayList<Cliente>();

    public Cliente() {
        id= Cliente.contador++;
        carrito = new Carro();
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Cliente.contador = contador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Carro getCarrito() {
        return carrito;
    }

    public void setCarrito(Carro carrito) {
        this.carrito = carrito;
    }
}
