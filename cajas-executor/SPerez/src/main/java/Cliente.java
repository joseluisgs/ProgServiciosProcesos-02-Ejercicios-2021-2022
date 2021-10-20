import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@Data
@AllArgsConstructor
public class Cliente {
	private String nombre;
	private Carro carroCompra;

	public Cliente (int id) {
		this.nombre = "Cliente " + id;
		this.carroCompra = new Carro();
	}
}
