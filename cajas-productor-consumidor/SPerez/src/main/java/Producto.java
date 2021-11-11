public class Producto {
	private int time;

	public Producto() {
		this.time = (int)((Math.random()*401) + 100);
	}

	public int getTime() {
		return this.time;
	}
}
