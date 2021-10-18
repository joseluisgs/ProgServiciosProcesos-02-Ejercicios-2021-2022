package org.andrea;

import java.io.File;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {


        
        Super supermercado = new Super(3,2);
        supermercado.procesoConcurrente();
        supermercado.procesoSecuencial();

    }
}
