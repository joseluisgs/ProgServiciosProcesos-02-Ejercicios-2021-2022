import lombok.Data;

import java.util.Stack;

@Data
public class Carrito {
    private Stack<Producto> cart = new Stack<>();
    private final int MAX_ITEM_AMOUNT =30;
    private int cartMaxItems = (int)(Math.random() * MAX_ITEM_AMOUNT)+1;

    private void fillCart(){
        for(int i=0;i<cartMaxItems;i++)
            cart.add(new Producto((int) (Math.random() * 5) + 1));
    }

    public Carrito(){
        fillCart();
    }
}
