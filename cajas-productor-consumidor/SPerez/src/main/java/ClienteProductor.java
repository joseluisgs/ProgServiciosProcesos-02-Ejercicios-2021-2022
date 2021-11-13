public class ClienteProductor extends Thread{
	private Cola<Cliente> recurso;
	private String idProductor;

	public ClienteProductor (Cola<Cliente> recurso, String id) {
		this.recurso = recurso;
		this.idProductor = id;
	}
	@Override
	public void run () {
		int i = 0;
		while (i < 15) {
			if (!recurso.addCliente(new Cliente("Cliente " + idProductor + "_" + i))) {
				System.out.println("Hay demasiados clientes! El cliente con id "+i+" se ha ido triste y desolado.");
			}else {
				System.out.println("Productor " + idProductor + " inserta al cliente " + idProductor + "_" + i);
			}
			i++;
			try {
				Thread.sleep((int)(Math.random() * 500)+500);
			} catch (InterruptedException e) {
				System.err.println("Productor con id " + idProductor + "ha sufrido un error de ejecución: " + e.getMessage());
			}
		}
	}
}
