import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        double initTime;
        String ultimas = "http://ep00.epimg.net/rss/tags/ultimas_noticias.xml";
        String tecnologia = "https://feeds.elpais.com/mrss-s/pages/ep/site/elpais.com/section/tecnologia/portada";
        String ciencia = "https://feeds.elpais.com/mrss-s/pages/ep/site/elpais.com/section/ciencia/portada";

        NoticiaHilo nh1 = new NoticiaHilo(ultimas);
        NoticiaHilo nh2 = new NoticiaHilo(tecnologia);
        NoticiaHilo nh3 = new NoticiaHilo(ciencia);

        initTime = System.currentTimeMillis();
        ExecutorService es = Executors.newFixedThreadPool(3);

        List<Callable<Noticia>> tareas = new ArrayList<>();
        tareas.add(nh1);
        tareas.add(nh2);
        tareas.add(nh3);

        List<Future<Noticia>> futures = es.invokeAll(tareas);

        for (Future<Noticia> future : futures) {
            future.get();
        }
        es.shutdown();

        System.out.println("El programa tarda " + (System.currentTimeMillis()-initTime) / 1000 + " seg en total en procesar los rss");

    }
}
