package dam;

import lombok.Data;

@Data
public class Client {
    private int numClient;
    private ShoppingCart shoppingCart;

    public Client(int numClient) {
        this.numClient = numClient;
        this.shoppingCart = new ShoppingCart();
    }
}