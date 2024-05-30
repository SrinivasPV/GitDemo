package API;

import Body.BodyReq;
import Body.ComplexParse;
import Body.Reusable;
import io.restassured.path.json.JsonPath;

public class ComplexParseJson {
	
	public static void main(String Args[])
	{
		JsonPath js = ComplexParse.coursePrice(BodyReq.mockResponse());
		int size = js.getInt("courses.size()");
		System.out.println(size);
		System.out.println(js.getInt("dashboard.purchaseAmount"));
		String c1 = js.getString("courses[0].title");
		System.out.println(c1);
		
		for(int i=0;i<size;i++)
		{
			System.out.println(js.getString("courses["+i+"].title"));
			System.out.println(js.getInt("courses["+i+"].price"));
		}
		
		//to get the price of RPA alone
		
		for(int i=0;i<size;i++)
		{
			String course = js.getString("courses["+i+"].title");
			
			if(course.equalsIgnoreCase("RPA"))
			{
				System.out.println(course);
				int price = js.getInt("courses["+i+"].price");
				System.out.println(price);
				break;
			}
		}
		
		//verify if sum of amount matches the purchase amount
		int sum=0;
		int pruchaseAmount=0;
		for(int i=0;i<size;i++)
		{
			
			int courseprise = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			sum=sum+(courseprise*copies);
			
			pruchaseAmount = js.getInt("dashboard.purchaseAmount");
			
		}
		System.out.println(sum+","+pruchaseAmount);
		
		if(sum==pruchaseAmount)
		{
			System.out.println("Tally");
		}
		else
			System.out.println("Not Tallied");
		
		
	}
	

}
