import org.xml.sax.SAXException;
import sax.SAXController;
import sax.model.Noticia;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class App {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("*** LECTOR DE NOTICIAS RSS ***");
        String INPUT_RSS_CIENCIA = System.getProperty("user.dir")+ File.separator+ "data" +File.separator+"portada_ciencia.rss";
        String INPUT_RSS_TECNOLOGIA = System.getProperty("user.dir")+ File.separator+ "data" +File.separator+"portada_tecnologia.rss";
        String INPUT_RSS_ULTIMAS = System.getProperty("user.dir")+ File.separator+ "data" +File.separator+"ultimas_noticias.xml";

        try {
            long inicio_programa = System.currentTimeMillis();
            System.out.println("Cargamos nuestros datos usando SAX desde fichero rss");
            SAXController controller_ciencia = new SAXController(INPUT_RSS_CIENCIA);
            SAXController controller_tecnologia = new SAXController(INPUT_RSS_TECNOLOGIA);
            SAXController controller_ultimas= new SAXController(INPUT_RSS_ULTIMAS);

            System.out.println("*** SAX RSS *** ");

            ExecutorService executorService = Executors.newFixedThreadPool(3);

            long inicio_task1 = System.currentTimeMillis();
            controller_ciencia.loadData();
            Callable<List<Noticia>> task1 = getTask1(controller_ciencia);
            long fin_task1 = System.currentTimeMillis();
            double tiempo_task1 = (double) ((fin_task1 - inicio_task1));
            System.out.println("Tiempo task1: "+tiempo_task1+" milisegundos");

            long inicio_task2 = System.currentTimeMillis();
            controller_tecnologia.loadData();
            Callable<List<Noticia>> task2 = getTask2(controller_tecnologia);
            long fin_task2 = System.currentTimeMillis();
            double tiempo_task2 = (double) ((fin_task2 - inicio_task2));
            System.out.println("Tiempo task2: "+tiempo_task2+" milisegundos");

            long inicio_task3 = System.currentTimeMillis();
            controller_ultimas.loadData();
            Callable<List<Noticia>> task3 = getTask3(controller_ultimas);
            long fin_task3 = System.currentTimeMillis();
            double tiempo_task3 = (double) ((fin_task3 - inicio_task3));
            System.out.println("Tiempo task3: "+tiempo_task3+" milisegundos");

            List<Callable<List<Noticia>>> taskList = Arrays.asList(task1, task2, task3);

            List<Future<List<Noticia>>> futures = executorService.invokeAll(taskList); // todas

            for(Future<List<Noticia>> future: futures) {
                // El resultado solo se imprime si todas las promesas/futuros se cumplen
                System.out.println(future.get());
            }
            long fin_programa = System.currentTimeMillis();
            double tiempo_programa = (double) ((fin_programa - inicio_programa));
            System.out.println("Tiempo programa: "+tiempo_programa+" milisegundos");
        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.err.println("ERROR:" + e.getMessage());
        }
    }

    private static Callable<List<Noticia>> getTask3(SAXController controller_ultimas) {
        Callable<List<Noticia>> task3 = () -> {
            System.out.println("Listando todos los elementos ULTIMAS NOTICIAS");
            return controller_ultimas.getNews();
        };
        return task3;
    }

    private static Callable<List<Noticia>> getTask2(SAXController controller_tecnologia) {
        return () -> {
                    System.out.println("Listando todos los elementos TECNOLOGIA");
                    return controller_tecnologia.getNews();
                };
    }

    private static Callable<List<Noticia>> getTask1(SAXController controller_ciencia) {
        return () -> {
                    System.out.println("Listando todos los elementos CIENCIA");
                    return controller_ciencia.getNews();
                };
    }
}