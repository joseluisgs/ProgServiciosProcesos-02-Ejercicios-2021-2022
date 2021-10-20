import rssReader.JDOMController;
import rssReader.RssToDom;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class rssReaderFuture {
    JDOMController jd = new JDOMController();
    public void readRss(String uri1, String uri2, String uri3, String out1, String out2, String out3) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<Integer> css1 = () ->{
            jd.domToXML(new RssToDom().rssReader(uri1),out1);
            return 1;
        };
        Callable<Integer> css2 = () ->{
            jd.domToXML(new RssToDom().rssReader(uri2),out2);
            return 2;
        };
        Callable<Integer> css3 = () ->{
            jd.domToXML(new RssToDom().rssReader(uri3),out3);
            return 3;
        };

        List<Callable<Integer>> listaCall = Arrays.asList(css1,css2,css3);

        try{
            executor.invokeAll(listaCall);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("terminado");
        executor.shutdown();
    }
}