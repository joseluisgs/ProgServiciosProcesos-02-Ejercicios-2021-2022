import model.Noticia;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {


    public static void main(String[] args) throws Exception {

        final String PATH= System.getProperty("user.dir")+ File.separator+ "data" +File.separator;
        final String INPUT_ULTIMAS_NOTICIAS = "http://ep00.epimg.net/rss/tags/ultimas_noticias.xml";
        final String INPUT_TECNOLOGIA = "https://feeds.elpais.com/mrss-s/pages/ep/site/elpais.com/section/tecnologia/portada";
        final String INPUT_CIENCIA = "https://feeds.elpais.com/mrss-s/pages/ep/site/elpais.com/section/ciencia/portada";

        SAXController controllerNoticias = new SAXController(INPUT_ULTIMAS_NOTICIAS);
        SAXController controllerTecnologia = new SAXController(INPUT_TECNOLOGIA);
        SAXController controllerCiencia = new SAXController(INPUT_CIENCIA);

        ExecutorService executorService = Executors.newFixedThreadPool(3);


        //Observé que estaba repitiendo mucho código así que lo metí en un metodo //
/*
        System.out.println("Se inicia la carga de datos de manera asíncrona");
        System.out.println("Se inicia el procesamiento del XML Ultimas Noticias");
        Future<List<Noticia>> resultadoUltimasNoticias= executorService.submit(controllerNoticias);
        System.out.println("Se inicia el procesamiento del XML Tecnologia");
        Future<List<Noticia>> resultadoTecnologia= executorService.submit(controllerTecnologia);
        System.out.println("Se inicia el procesamiento del XML Ciencia");
        Future<List<Noticia>> resultadoCiencia= executorService.submit(controllerCiencia);

*/
        List<Noticia> listaUltimasNoticias =procesarAsincrono(executorService,controllerNoticias).get();
        List<Noticia> listaTecnologia =procesarAsincrono(executorService,controllerTecnologia).get();
        List<Noticia> listaCiencia =procesarAsincrono(executorService,controllerCiencia).get();

        System.out.println("Lista de todas las noticias");

        List<Noticia> resultList =Stream.concat(listaUltimasNoticias.stream(), listaTecnologia.stream()).collect(Collectors.toList());
        resultList.addAll(listaCiencia);
        resultList.forEach((p)-> {
            System.out.println(p.toString());
        });


        System.out.println("Tiempo tardado:\n" +
                "Últimas noticias ---> "+ controllerNoticias.getTiempo() + "\n" +
                "Tecnología ---> "+ controllerTecnologia.getTiempo() + "\n" +
                "Ciencia --->"+  controllerCiencia.getTiempo()
        );
        System.out.println(" ");
        System.out.println("Noticias procesadas:\n" +
                "Últimas noticias ---> "+ controllerNoticias.getNoticias().size() + "\n" +
                "Tecnología ---> "+ controllerTecnologia.getNoticias().size() + "\n" +
                "Ciencia --->"+  controllerCiencia.getNoticias().size()
        );



    }

public static  Future<List<Noticia>>procesarAsincrono(ExecutorService executor, SAXController controlador){

    Future<List<Noticia>> resultado= executor.submit(controlador);

    return resultado;
}

}
