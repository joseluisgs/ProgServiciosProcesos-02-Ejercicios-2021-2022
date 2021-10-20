import rssReader.JDOMController;

import java.io.File;

public class App {
    public static void main(String[] args) {
        String rssLN = "http://ep00.epimg.net/rss/tags/ultimas_noticias.xml";
        String rssTec = "https://feeds.elpais.com/mrss-s/pages/ep/site/elpais.com/section/tecnologia/portada";
        String rssCi = "https://feeds.elpais.com/mrss-s/pages/ep/site/elpais.com/section/ciencia/portada";

        String resourcesPath = System.getProperty("user.dir")+ File.separator+"ERebollo"+File.separator+"rssAsincronia"+File.separator+"src"+File.separator+"main"+File.separator+"resources";
        System.out.println(resourcesPath);
        String rssLNPath = resourcesPath+File.separator+"ultimaNoticias.xml";
        String rssTecPath = resourcesPath+File.separator+"tecnologia.xml";
        String rssCiPath = resourcesPath+File.separator+"ciencia.xml";

        rssReaderFuture reader = new rssReaderFuture();
        reader.readRss(rssLN,rssTec,rssCi,rssLNPath,rssTecPath,rssCiPath);

    }
}
