package basic.xmlProcessor;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javaRepositories.Print;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner fileScanner = null;
		String filePath = "C:\\Users\\smoreira\\Documents\\Documentos\\Trilhas e cursos\\Cursos\\java\\basic\\xmlProcessor\\xml.xml";
		File file = new File(filePath);

		String fileContent = ProcessorXml.processorFile(filePath);
		Print.println("File");
		Print.println(fileContent);

		String json = ProcessorXml.convertXmlToJson(fileContent);
		Print.println("\nJson");
		Print.println(json);
		
		String xml = ProcessorXml.convertJsonToXml(json.toString());
		Print.println("\nXml");
		Print.println(xml);
	}
}
