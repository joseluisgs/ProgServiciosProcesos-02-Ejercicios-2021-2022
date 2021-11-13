import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main (String[] args) {
		Cola<Cliente> cola = new Cola<>(10);
		ClienteProductor productor = new ClienteProductor(cola, "P1");
		ClienteProductor productor2 = new ClienteProductor(cola, "P2");
		productor.start();
		productor2.start();
		List<Cajero> cajeros = new ArrayList<>();
		for (int i = 0; i < 3 ; i++) {
			cajeros.add (new Cajero(cola, "Caja"+i));
			cajeros.get(i).start();
		}
		try {
			for (Cajero cajero: cajeros) {
				cajero.join();
			}
			productor.join();
			productor2.join();
		} catch (InterruptedException e) {
			System.err.println("Error joining thread:" + e.getMessage());
		}
	}
}
