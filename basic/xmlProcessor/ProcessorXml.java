package xmlProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
}
