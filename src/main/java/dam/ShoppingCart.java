package dam;

import lombok.Data;

@Data
public class ShoppingCart {
    private Product[] products;

    public ShoppingCart() {
        this.products = new Product[(int)((Math.random()*30)+1)];
        for (int i = 0; i < products.length; i++) {
            products[i] = new Product(i+1);
        }
    }
}
