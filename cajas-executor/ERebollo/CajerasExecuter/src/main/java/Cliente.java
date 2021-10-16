import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Stack;

@Data
public class Cliente {

    private int clientNumber;
    private Stack<Producto> carro = new Carrito().getCart();

    public Cliente(int numero){
        this.clientNumber=numero;
    }





}
