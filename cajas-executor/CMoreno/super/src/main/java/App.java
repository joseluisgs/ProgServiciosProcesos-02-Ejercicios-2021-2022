import service.Supermercado;

public class App
{
    public static void main(String[] args) {
        boolean repetir;
        try {
            // No se podrá pasar por parámetro númros negativos ni letras
            if (Integer.parseInt(args[0]) > 1 && Integer.parseInt(args[1]) > 0) {
                Supermercado.bienvenida();
                Supermercado.initDatos(Integer.parseInt(args[1]));
                Supermercado.paralelo(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
                Supermercado.secuencial(Integer.parseInt(args[1]));
                Supermercado.despedida();
            } else {
                System.err.println(
                        "Error de sintaxis, debe de haber cajas y clientes para ejeutar el programa."
                );
            }
        } catch (Exception e) {
            System.out.println("Valor no válido " + e.toString());
        }
    }
}