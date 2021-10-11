package dam;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CheckOut {
    private String checkOutName;

    public void processPurchase(Client client, long timestamp){
        System.out.println("The CheckOut "+getCheckOutName()+
                " Starts to processing the purchase of the Client "
                + client.getNumClient() + " in the time: " +
                (System.currentTimeMillis() - timestamp)/1000 + "sec");
        for (int i= 0; i<client.getShoppingCart().getProducts().length; i++){
            this.waitXSeconds(client.getShoppingCart().getProducts()[i].getTimeOfProcess());
            System.out.println(("CheckOut "+getCheckOutName() + " Processing Client "+client.getNumClient()+
                    " product " + client.getShoppingCart().getProducts()[i].getNumProduct()
                    + " -> Time: " + (System.currentTimeMillis() - timestamp)/1000 + "sec"));
        }
        System.out.println("The CheckOut " + this.getCheckOutName() + " finish processing the Client " +
                client.getNumClient() + " in the time: "+
                (System.currentTimeMillis() - timestamp)/1000 + "sec");
    }


    public void waitXSeconds(int seconds){
        try{
            Thread.sleep(seconds * 1000);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
}
