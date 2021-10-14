package Supermercado;

public class Cajas {

    private Caja[] cajas;

    public Cajas(int numCajas) {
        if (numCajas <= 0) {
            System.out.println("Al menos debe de haber una caja ");
            System.exit(0);
        } else {
            cajas = new Caja[numCajas];
            llenarCajas(cajas);
        }
    }
    private void llenarCajas(Caja[] cajas) {
        for (int i = 0; i < cajas.length; i++) {
            Caja caja = new Caja();
            cajas[i] = caja;
        }
    }

    public Caja[] getCajas() {
        return cajas;
    }

    public void setCajas(Caja[] cajas) {
        this.cajas = cajas;
    }
}
