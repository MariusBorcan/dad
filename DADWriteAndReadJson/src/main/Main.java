package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args) throws IOException, ParseException {
		writeJson();
		readJson();
	}
	
	private static void writeJson() throws FileNotFoundException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("firstName", "John");
		jsonObject.put("lastName", "Doe");
		jsonObject.put("age", 25);
		JSONObject addressObject = new JSONObject();
		addressObject.put("street", "Street");
		addressObject.put("number", 10);
		jsonObject.put("adress", addressObject);
		JSONArray jsonArray = new JSONArray();
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", "home");
		map.put("phone", "1234");
		jsonArray.add(map);
		map = new HashMap<String, String>();
		map.put("type", "mobile");
		map.put("phone", "5678");
		jsonArray.add(map);
		jsonObject.put("adresses", jsonArray);
		File file = new File("/home/marius/Desktop/main.json");
		PrintWriter printWriter = new PrintWriter(file);
		printWriter.write(jsonObject.toJSONString());
		printWriter.flush();
		printWriter.close();
	}
	
	private static void readJson() throws IOException, ParseException {
		File file = new File("/home/marius/Desktop/main.json");
		FileReader fileReader = new FileReader(file);
		JSONParser jsonParser = new JSONParser();
		Object obj = jsonParser.parse(fileReader);
		JSONObject jsonObject = (JSONObject) obj;
		System.out.println(jsonObject.get("firstName"));
	}

}
