public class Main {


    public static void main(String[] args) {
            // con esto conseguimos que se pueda ejecutar el programa con la llamada como   por ejemplo java -jar super.ja3 3 21


       int numCajas = Integer.parseInt(args[0]);
        int numCostumers = Integer.parseInt(args[1]);


            //Obligamos a que se tengan que introducir los dos parametros para que se inicie
          if (args.length == 2 && numCajas > 0 && numCostumers > 0) {

            FormaSecuencial.cajasSecuencial(numCajas);
            FormaConcurrente.cajasConcurrentes(numCajas, numCostumers);

        } else {
            System.out.println("Los parametros que has introducido no son correcotos : " + numCajas + " " + numCostumers + " porfavor introduzca en el primer lugar el numero" +
                    "de cajas y en el segundo el numero de costumers");
        }

    }
}