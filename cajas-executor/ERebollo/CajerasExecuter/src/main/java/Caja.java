import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Caja extends Thread {

    private Cliente client;
    private int officeNumber;

    public void run() {
        System.out.println("La caja "+this.officeNumber+" abre sus puertas");
        clientCheck(client);
        System.out.println("La caja "+this.officeNumber+" cierra sus puertas");
    }

    private void clientCheck(Cliente client){
        for(int i=0;i<client.getCart().size();i++){
            try {
                System.out.println("caja "+this.officeNumber+" con el producto "+i+" del cliente "+client.getClientNumber());
                Thread.sleep(client.getCart().get(i).getWaitTime() * 1000L);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
