package dam;

import lombok.Data;
import java.util.ArrayDeque;

@Data
public class Clients{
    private ArrayDeque<Client> clientQueue;

    public Clients(int numElements) {
        this.clientQueue = new ArrayDeque<>(numElements);
        for (int i = 0; i<numElements;i++ ){
            clientQueue.add(new Client(i+1));
        }
    }
}
