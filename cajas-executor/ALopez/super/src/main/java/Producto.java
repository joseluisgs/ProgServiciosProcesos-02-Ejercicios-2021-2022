import lombok.Data;

import java.util.Random;

@Data
public class Producto {
    //Creamos las variables que van dentro de Producto
    // tenemos el tiempo de procesado y el numero de Productos que esta acotado en la clase carro
    private int tiempoDeProcesado;
    private int numProductos;

    public Producto(int numProductos) {

        this.tiempoDeProcesado = new Random().nextInt(5)+1;
        this.numProductos = numProductos;


    }


}
