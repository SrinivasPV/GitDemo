package API;

import io.restassured.RestAssured;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Body.BodyReq;
import Body.Reusable;

public class BasicAPICode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ADD PLACE

		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(BodyReq.addPlace())
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		
		//JsonPath js = new JsonPath(response);
		JsonPath js = Reusable.rawToJson(response);
		String place = js.getString("place_id");
		System.out.println(place);
		
		//UPDATE PLACE
		String address="70 winter walk, USA";
		
		given().log().all().queryParam("key", "qaclick123").body("{\r\n"
				+ "\"place_id\":\""+place+"\",\r\n"
				+ "\"address\":\""+address+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		.header("Content-Type","application/json")
		.when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//GET PLACE
		
		String getAdd = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", place)
		.when().get("/maps/api/place/get/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(getAdd);
		
		JsonPath j = Reusable.rawToJson(getAdd);
		String string = j.getString("address");
		System.out.println(string);
		
		Assert.assertEquals(string, address);
		
	}
	

}
