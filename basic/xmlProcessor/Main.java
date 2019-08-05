package sabrina.bootcamp;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner fileScanner = null;
		String filePath = "C:\\Users\\jvealuno\\eclipse-workspace\\xmlProcessador\\src\\xml.xml";
        File file = new File(filePath);
        
        String fileContent = ProcessorXml.processorFile(filePath);
		Print.println("File");
		Print.println(fileContent);
		
        String json = ProcessorXml.convertXmlToJsonHard(fileContent);
		
        /*
		String json = ProcessorXml.convertXmlToJson(fileContent);
		Print.println("\nJson");
		Print.println(json);
		
		String xml = ProcessorXml.convertJsonToXml(json.toString());
		Print.println("\nXml");
		Print.println(xml);
		
		String html = ProcessorXml.convertXmlToHtml(filePath);
		Print.println("\nHtml");
		Print.println(html);
		*/
	}
}
