package sabrina.bootcamp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;
import org.json.XML;

public class ProcessorXml {
	public static String processorFile(String filePath) throws IOException {
		byte[] fileContent = Files.readAllBytes(Paths.get(filePath));
		
		return new String(fileContent, "ISO-8859-1");
		
	}
	
	public static String convertXmlToJson(String fileContent) {
		JSONObject json = XML.toJSONObject(fileContent);
		
		return json.toString();
	}
	
	public static String convertJsonToXml(String fileContent) {
        JSONObject json = new JSONObject(fileContent);
        String xml = XML.toString(json);
		
		return xml.toString();
	}
	
	public static String convertXmlToJsonHard(String fileContent) {	
		/*charAt, indexOf, substring, split*/
		
		String[] fileContentStrings = fileContent.split("/>");
		fileContentStrings = fileContent.split(">");
		fileContentStrings = Arrays.toString(fileContentStrings).split("<");
		fileContentStrings = Arrays.toString(fileContentStrings).split(",");
		fileContentStrings = fileContent.split("/");
		//fileContentStrings = Arrays.toString(fileContentStrings).split(" ");
		 
		Tag xml = new Tag();
		
		Print.print(xml.toString());
		
        return null;
	}
		
	/*
	public static String convertXmlToHtml() {
		try {

		    TransformerFactory tFactory = TransformerFactory.newInstance();

		    Transformer transformer =
		      tFactory.newTransformer
		         (new javax.xml.transform.stream.StreamSource
		            ("howto.xsl"));

		    transformer.transform
		      (new javax.xml.transform.stream.StreamSource
		            ("howto.xml"),
		       new javax.xml.transform.stream.StreamResult
		            ( new FileOutputStream("howto.html")));
		    } catch (Exception e) {
		    	e.printStackTrace( );
		    }
		}
	}*/
}
