package API;

import org.testng.Assert;
import org.testng.annotations.Test;

import Body.BodyReq;
import io.restassured.path.json.JsonPath;


public class TestNGComplexParseJson {
	@Test
	public void sumOfCourses()
	{
	int sum=0;
	JsonPath js = new JsonPath(BodyReq.mockResponse());
	System.out.println(js.getInt("courses[0].price"));
//	int count=	js.getInt("courses.size()");
//	for(int i=0;i<count;i++)
//	{
//		int price=js.getInt("courses["+i+"].price");
//		int copies=js.getInt("courses["+i+"].copies");
//		int amount = price * copies;
//		System.out.println(amount);
//		sum = sum + amount;
//		
//	}
//	System.out.println(sum);
//	int purchaseAmount =js.getInt("dashboard.purchaseAmount");
//	Assert.assertEquals(sum, purchaseAmount);
}

}
