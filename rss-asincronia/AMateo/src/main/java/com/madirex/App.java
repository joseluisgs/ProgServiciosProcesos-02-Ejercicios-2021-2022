package com.madirex;


import com.madirex.sax.SAXController;
import com.madirex.sax.model.Post;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String INPUT_XML1 = System.getProperty("user.dir") + File.separator + "data" + File.separator + "ciencia.rss";
        String INPUT_XML2 = System.getProperty("user.dir") + File.separator + "data" + File.separator + "tecno.rss";
        String INPUT_XML3 = System.getProperty("user.dir") + File.separator + "data" + File.separator + "ultimas_noticias.xml";

        long initialTime = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Callable<List<Post>> task1 = () -> {
            SAXController controller = SAXController.getInstance(INPUT_XML1);
            controller.loadData();
            System.out.println("El primer RSS se ha cargado en " + (System.currentTimeMillis() - initialTime) + "segundos");
            return controller.getPosts();
        };

        Callable<List<Post>> task2 = () -> {
            SAXController controller = SAXController.getInstance(INPUT_XML2);
            controller.loadData();
            System.out.println("El segundo RSS se ha cargado en " + (System.currentTimeMillis() - initialTime) + "segundos");
            return controller.getPosts();
        };

        Callable<List<Post>> task3 = () -> {
            SAXController controller = SAXController.getInstance(INPUT_XML3);
            controller.loadData();
            System.out.println("El tercer RSS se ha cargado en " + (System.currentTimeMillis() - initialTime) + "segundos");
            return controller.getPosts();
        };

        List<Callable<List<Post>>> taskList = Arrays.asList(task1, task2, task3);
        List<Future<List<Post>>> futures = executorService.invokeAll(taskList); // todas

        for(Future<List<Post>> future: futures) {
            System.out.println(future.get());
        }

        executorService.shutdown();

        long finalTime = System.currentTimeMillis();

        System.out.println("El programa ha terminado en " + ((finalTime - initialTime)) + " milisegundos");


    }

}