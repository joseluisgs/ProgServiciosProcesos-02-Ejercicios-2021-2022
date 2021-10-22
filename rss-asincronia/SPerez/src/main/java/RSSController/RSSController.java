package RSSController;

import model.RSSItem;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RSSController {
	private static RSSController instance;
	private Document xmlFile;
	private String uri;

	public RSSController (String uri) {
		this.uri = uri;
		try {
			loadDocument();
		}catch (Exception ex) {
			System.err.println("Couldn´t load the XML File");
		}
	}

	private void initDocument() throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		xmlFile = dBuilder.newDocument();
	}

	private void loadDocument () throws IOException, SAXException, ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder() ;
		xmlFile = dBuilder.parse(this.uri);
		xmlFile.normalize();
	}

	public ArrayList<RSSItem> getRSSItems () {
		ArrayList<RSSItem> collection = new ArrayList<>();
		for (int i = 0; i < this.xmlFile.getElementsByTagName("item").getLength(); i++) {
			RSSItem item = new RSSItem();
			for (Node node = this.xmlFile.getElementsByTagName("item").item(i).getFirstChild();
			     node != null; node = node.getNextSibling()) {
				if (node.getNodeName().equals("title"))
					item.setTitle(node.getTextContent());
				else if (node.getNodeName().equals("link"))
					item.setLink(node.getTextContent());
				else if (node.getNodeName().equals("description"))
					item.setDescription(node.getTextContent());
				else if (node.getNodeName().equals("pubDate"))
					item.setPubDate(LocalDate.parse(node.getTextContent(), DateTimeFormatter.RFC_1123_DATE_TIME));
			}
			collection.add(item);
		}
		return collection;
	}
}
