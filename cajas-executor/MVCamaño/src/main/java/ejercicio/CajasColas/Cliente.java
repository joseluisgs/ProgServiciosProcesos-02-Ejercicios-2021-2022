package ejercicio.CajasColas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    String nombre;
    CarritoCompra carritoCompra;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CarritoCompra getCarritoCompra() {
        return carritoCompra;
    }

    public void setCarritoCompra(CarritoCompra carritoCompra) {
        this.carritoCompra = carritoCompra;
    }

}
