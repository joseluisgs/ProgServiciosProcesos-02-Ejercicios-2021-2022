package cajas;

import lombok.Data;

@Data
public class Cliente {
    private int numCliente;
    private CajeraHebra CarroCompra;

    public Cliente(int numCliente) {
        this.numCliente = numCliente;
        this.CarroCompra = new CajeraHebra();
    }
}
