import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Stack;

@Data
@AllArgsConstructor
public class Cliente {

    private int clientNumber;
    private final int MAX_ITEM_AMOUNT =30;
    private int cartMaxItems = (int)(Math.random() * MAX_ITEM_AMOUNT)+1;
    private Stack<Producto> cart = new Stack<>();

    public Cliente(int numero){
        this.clientNumber=numero;
        fillCart();
    }

    private void fillCart(){
        for(int i=0;i<MAX_ITEM_AMOUNT;i++)
            cart.add(new Producto((int) (Math.random() * 5) + 1));
    }



}
