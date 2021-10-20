import org.xml.sax.SAXException;
import sax.SAXController;
import sax.model.News;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        String lastNews =System.getProperty("user.dir")+File.separator+"FSToledo"+File.separator+"data"+File.separator+"ultimas_noticias.xml";
        String technology =System.getProperty("user.dir")+File.separator+"FSToledo"+File.separator+"data"+File.separator+"portada_tecnologia.xml";
        String science =System.getProperty("user.dir")+File.separator+"FSToledo"+File.separator+"data"+File.separator+"portada_ciencia.xml";
        try {
            SAXController saxLastNews = new SAXController(lastNews);
            SAXController saxTech = new SAXController(technology);
            SAXController saxScience = new SAXController(science);

            System.out.println("---RSS ASYNC READER---");

            ExecutorService executor = Executors.newFixedThreadPool(3);
            long initialTime = System.currentTimeMillis();

            Callable<List<News>> rssReaderOne = ()->{
            saxLastNews.loadData();
                long firstReaderTime = System.currentTimeMillis();
                System.out.println("First reader ends to read at "+(firstReaderTime-initialTime));
              return  saxLastNews.getNews();
            };
            Callable<List<News>> rssReaderTwo =()->{
                saxScience.loadData();
                long secondReaderTime = System.currentTimeMillis();
                System.out.println("Second reader ends to read at "+(secondReaderTime-initialTime));
                return  saxScience.getNews();
            };
            Callable<List<News>> rssReaderThree =()->{
                saxTech.loadData();
                long thirdReaderTime = System.currentTimeMillis();
                System.out.println("Third reader ends to read at "+(thirdReaderTime-initialTime));
                return  saxTech.getNews();
            };
            List<Callable<List<News>>> rssThreads = Arrays.asList(rssReaderOne,rssReaderTwo,rssReaderThree);
            List<Future<List<News>>> futureThreads = executor.invokeAll(rssThreads);
            System.out.println("The 3 readers has been finished at "+(System.currentTimeMillis() - initialTime));
            System.out.println("");
            int contListado=1;
            for(Future<List<News>> future : futureThreads){
                System.out.println("------List of news of RSS "+contListado+"-----");
                System.out.println("Number of news: "+future.get().size());
                future.get().forEach(System.out::println);
                contListado++;
            }
            executor.shutdown();
            long endTime = System.currentTimeMillis();
            System.out.println("The program has been finished at "+(endTime - initialTime));
        } catch (InterruptedException | ExecutionException   e) {
            e.printStackTrace();
        }
    }

}
