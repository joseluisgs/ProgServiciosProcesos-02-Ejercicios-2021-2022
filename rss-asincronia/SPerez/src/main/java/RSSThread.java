import RSSController.RSSController;

import java.util.concurrent.Future;

public class RSSThread extends Thread {
	private String uri;
	private Long time;

	public RSSThread (String uri) {
		this.uri = uri;
	}

	@Override
	public void run() {
		this.time = System.currentTimeMillis();
		RSSController xmlController = new RSSController(this.uri);
		xmlController.getRSSItems().forEach(System.out::println);
		this.time = System.currentTimeMillis() - this.time;
	}

	public long getTime() {
		return this.time;
	}
}
