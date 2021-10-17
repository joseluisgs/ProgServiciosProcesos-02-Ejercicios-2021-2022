package dam;

import lombok.Data;

@Data
public class Product {
    private int numProduct;
    private int timeOfProcess;

    public Product(int numProduct) {
        this.numProduct = numProduct;
        this.timeOfProcess = (int) ((Math.random() * 5)+1);
    }

}