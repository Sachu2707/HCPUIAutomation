package businessComponents;

import com.relevantcodes.extentreports.LogStatus;
import commonHelper.HelperClass;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import utils.ExtentReportListner;
import static io.restassured.RestAssured.given;

@Listeners(ExtentReportListner.class)
public class TestPATCHAPI extends ExtentReportListner {

	public void Updatebooking() {
		given().when().get("https://restful-booker.herokuapp.com").then().statusCode(200);
		// Read test data from JSON
		HelperClass.authToken();
		String Fname = HelperClass.TestData("Fname");
		String Lname = HelperClass.TestData("Lname");
		String payload = "{\n" + " \"firstname\" : \"" + Fname + "\",\n" + " \"lastname\":\"" + Lname + "\"\n" + "}";

		test.log(LogStatus.INFO, "Test Data Driven from JSON" + Fname + Lname);
		given().baseUri("https://restful-booker.herokuapp.com").contentType("application/json").body(payload)
				.header("Cookie", "token=" + HelperClass.getToken).log().all().when().patch("/booking/1").then().log()
				.all().assertThat().statusCode(200);

		test.log(LogStatus.INFO, "Status Code :200 OK");

	}
}