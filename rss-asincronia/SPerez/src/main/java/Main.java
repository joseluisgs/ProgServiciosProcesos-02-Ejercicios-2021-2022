import RSSController.RSSController;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main (String[]args) {
		long sequentialTime = System.currentTimeMillis();
		sequentialRSS();
		sequentialTime = System.currentTimeMillis() - sequentialTime;
		long concurrentTime = System.currentTimeMillis();
		concurrentRSS();
		concurrentTime = System.currentTimeMillis() - concurrentTime;
		System.out.println("Sequential Time: " + sequentialTime);
		System.out.println("Concurrent Time: " + concurrentTime);
	}

	public static void sequentialRSS () {
		RSSController xmlController = new RSSController("http://ep00.epimg.net/rss/tags/ultimas_noticias.xml");
		xmlController.getRSSItems().forEach(System.out::println);
		xmlController = new RSSController("https://feeds.elpais.com/mrss-s/pages/ep/site/elpais.com/section/tecnologia/portada");
		xmlController.getRSSItems().forEach(System.out::println);
		xmlController = new RSSController("https://feeds.elpais.com/mrss-s/pages/ep/site/elpais.com/section/ciencia/portada");
		xmlController.getRSSItems().forEach(System.out::println);
	}

	public static void concurrentRSS () {
		ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
		RSSThread thread1 = new RSSThread("http://ep00.epimg.net/rss/tags/ultimas_noticias.xml");
		RSSThread thread2 = new RSSThread("https://feeds.elpais.com/mrss-s/pages/ep/site/elpais.com/section/tecnologia/portada");
		RSSThread thread3 = new RSSThread("https://feeds.elpais.com/mrss-s/pages/ep/site/elpais.com/section/ciencia/portada");
		pool.execute(thread1);
		pool.execute(thread2);
		pool.execute(thread3);
		pool.shutdown();
		while(pool.getActiveCount() != 0) {
			try {
				Thread.sleep(1);
			}catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("Timings:\n" +
				"thread 1: "+ thread1.getTime() + "\n" +
				"thread 2: "+ thread2.getTime() + "\n" +
				"thread 3: "+ thread3.getTime()
		);
	}
}
