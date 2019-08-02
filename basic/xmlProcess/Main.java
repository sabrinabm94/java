package sabrina.bootcamp;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner fileScanner = null;
		String filePath = "C:\\Users\\jvealuno\\eclipse-workspace\\xmlProcessador\\src\\xml.xml";
        File file = new File(filePath);
        
        String fileContent = ProcessXml.processFile(filePath);
		Print.println("File");
		Print.println(fileContent);
		
        String json = ProcessXml.convertXmlToJsonHard(fileContent);
		
        /*
		String json = ProcessXml.convertXmlToJson(fileContent);
		Print.println("\nJson");
		Print.println(json);
		
		String xml = ProcessXml.convertJsonToXml(json.toString());
		Print.println("\nXml");
		Print.println(xml);
		
		String html = processXml.convertXmlToHtml(filePath);
		Print.println("\nHtml");
		Print.println(html);
		*/
	}
}
