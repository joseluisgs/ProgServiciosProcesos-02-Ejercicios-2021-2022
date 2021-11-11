
public class Cliente {
	private String id;
	private Carro carro;

	public Cliente (String id) {
		this.id = id;
		this.carro = new Carro(10);
	}

	public Cliente () {
		this.carro = new Carro(10);
	}

	public Carro getCarro() {
		return this.carro;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
