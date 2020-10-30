package generateMeans;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Reader {

	public static final void main(String argv[]) {
		Reader.initial();
	}
	
	public static Document getDocument(String nameXML) throws Exception {
		File fXmlFile = new File(nameXML);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);

		// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();

		return doc;
	}
	
	public static void initial() {
		Calculator saveCalculations = new Calculator();
		
		try (Stream<Path> paths = Files.walk(Paths.get("formularios"))) {
			paths.filter(Files:isRegularFile).forEach(saveCalculations:addFormToMean); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		saveCalculations.printMean();
	}
}
