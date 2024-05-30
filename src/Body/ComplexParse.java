package Body;

import io.restassured.path.json.JsonPath;

public class ComplexParse {
	
	public static JsonPath coursePrice(String response)
	{
		JsonPath js= new JsonPath(response);
		return js;
	}

}
