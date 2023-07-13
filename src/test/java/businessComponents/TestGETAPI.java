package businessComponents;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.ExtentReportListner;
import static io.restassured.RestAssured.*;

@Listeners(ExtentReportListner.class)
public class TestGETAPI extends ExtentReportListner {
	public void getBookingIds() {
		given().when().get("https://restful-booker.herokuapp.com").then().statusCode(200);
		int statuscode = given().baseUri("https://restful-booker.herokuapp.com").contentType("application/json").when()
				.get("/booking").then().extract().response().statusCode();
		System.out.println("statuscode: " + statuscode);
		// Assert the status code
		Assert.assertEquals(statuscode, 200);
		if (statuscode == 200) {
			test.log(LogStatus.PASS, "Status code is 200 OK");
		} else
			test.log(LogStatus.FAIL, "API Failed");
	}
}