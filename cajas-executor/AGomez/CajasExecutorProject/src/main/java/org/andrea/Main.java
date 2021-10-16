package org.andrea;

import java.io.File;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {


        System.out.println(System.getProperty("user.home"+ File.separator+"IdeaProjects"));
        Super supermercado = new Super(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        supermercado.procesoConcurrente();
        supermercado.procesoSecuencial();

    }
}
