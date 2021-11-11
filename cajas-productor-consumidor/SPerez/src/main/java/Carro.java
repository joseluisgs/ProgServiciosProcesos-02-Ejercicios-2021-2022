import java.util.Stack;

public class Carro {
	private Stack<Producto> productos;
	private int capacidadMaxima;

	public Carro(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
		this.productos = new Stack<>();
		int numeroDeProductos = (int)(Math.random() *10)+1;
		int i = 0 ;
		while (i < numeroDeProductos) {
			this.productos.add(new Producto());
			i++;
		}
	}

	public boolean isEmpty(){
		return this.productos.isEmpty();
	}

	public boolean isFull() {
		return this.productos.size() >= this.capacidadMaxima;
	}

	public Producto nextProducto(){
		if (!productos.isEmpty()) {
			return productos.pop();
		}else return null;
	}
}
