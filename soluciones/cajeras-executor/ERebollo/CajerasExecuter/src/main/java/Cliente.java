import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cliente {

    private int clientNumber;
    private final int MAX_ITEM_AMOUNT =30;
    private int cartMaxItems = (int)(Math.random() * MAX_ITEM_AMOUNT)+1;
    private Producto[] cart = new Producto[cartMaxItems];

    public Cliente(){
        fillCart();
    }

    private void fillCart(){
        for(int i=0;i<cart.length;i++)
            cart[i] = new Producto((int) (Math.random() * 5) + 1);
    }



}
