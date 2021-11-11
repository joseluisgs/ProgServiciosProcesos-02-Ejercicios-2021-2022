import java.util.NoSuchElementException;

public class Cajero extends Thread{
	private Cola<Cliente> recurso;
	private String consumidorId;

	public Cajero (Cola<Cliente> cola, String id) {
		this.recurso = cola;
		this.consumidorId = id;
	}

	@Override
	public void run () {
		int loopsWithoutClients = 0;
		try {
			while (loopsWithoutClients < 15) {
				if (!this.recurso.isEmpty()) {
					try {
						Cliente cliente = this.recurso.nextCliente();

						if (cliente != null) {
							System.out.println("Cajero con id " + consumidorId + " procesa al cliente " + cliente.getId());
							while (!cliente.getCarro().isEmpty()) {
								Thread.sleep(cliente.getCarro().nextProducto().getTime());
							}
						}
						loopsWithoutClients = 0;
					} catch (NoSuchElementException e) {
						System.err.println("Otra caja me ha robado al cliente!");
					}
				}else {
					System.out.println("El consumidor "+consumidorId+" no puede consumir ningun cliente, esperando...");
					Thread.sleep(1000);
					loopsWithoutClients++;
				}
			}
		}catch (InterruptedException e) {
			System.err.println("Error en el cajero con id "+consumidorId+" : " + e.getMessage());
		}

	}
}
