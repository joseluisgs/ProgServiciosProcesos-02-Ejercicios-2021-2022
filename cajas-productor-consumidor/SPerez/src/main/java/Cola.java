

import java.util.Deque;
import java.util.LinkedList;

public class Cola<T> {
	private final int capacidadMaxima;
	private Deque<T> pila;
	public Cola(int nPosiciones) {
		this.capacidadMaxima = nPosiciones;
		this.pila = new LinkedList<T>();
	}

	public boolean isEmpty(){
		return this.pila.isEmpty();
	}

	public boolean isFull() {
		return this.pila.size() >= this.capacidadMaxima;
	}

	public synchronized boolean addCliente(T cliente) {
		if (!this.isFull()) {
			this.pila.add(cliente);
			return true;
		} else {
			return false;
		}
	}

	public synchronized T nextCliente() {
		if (!this.isEmpty())
			return this.pila.removeFirst();
		else return null;
	}
}
