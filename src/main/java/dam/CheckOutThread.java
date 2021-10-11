package dam;

import lombok.Data;

@Data
public class CheckOutThread extends Thread {
    private String checkOutName;
    private Client client;
    private long initialTime;

    @Override
    public void run(){
        System.out.println("The Checkout "+this.checkOutName+
                " Start to process the purchase of the Client " + client.getNumClient() +
                " in the time: " + (System.currentTimeMillis() - initialTime)/1000 + "sec");
        for (int i= 0; i < client.getShoppingCart().getProducts().length; i++){
            this.waitXSeconds(client.getShoppingCart().getProducts()[i].getTimeOfProcess());
            System.out.println(("Checkout " + this.checkOutName + " Processing the Client "+
                    client.getNumClient()+" product " +
                    client.getShoppingCart().getProducts()[i].getNumProduct()
                    + " -> Time: " + (System.currentTimeMillis() - initialTime)/1000 + "sec"));
        }
        System.out.println("The Checkout " + this.checkOutName + " finished to process the client "
                + client.getNumClient() + " in the time: "+
                (System.currentTimeMillis() - initialTime)/1000 + "sec");
    }
    public CheckOutThread(String checkOutName,Client client,long initialTime){
        this.checkOutName = checkOutName;
        this.client = client;
        this.initialTime = initialTime;
    }
    public void waitXSeconds(int seconds){
        try{
            Thread.sleep(seconds * 1000);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }

}
