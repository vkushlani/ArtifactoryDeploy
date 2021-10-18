package DataLoads;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getJsonData(String jSonFilePath) throws IOException
	{
		
		//Convert json file content to json string
		//For FIleUtils needed apache commons io dependency. Below method is used to convert json to string
		String jsonContent = FileUtils.readFileToString(new File("reservationDetails.json"),StandardCharsets.UTF_8);
		
		//mapper object below convert string to HashMap
		//We have recieved 'jsonContent' which is a string and it came after json was converted to sting by FileUtils method above
		//So jSon ==> String==>hashMap
		//readvalue method will create hashmaps. for every hashmaps it wiil create list
		//TypeReference convert json to hashmaps (Marshals and Unmarshals data into required data type), Below it convert from json to List of Hashmaps
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
		
	}
}
