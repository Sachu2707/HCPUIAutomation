package commonHelper;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static io.restassured.RestAssured.given;

public class HelperClass {

	public static String API_TOKEN = "";
	public static String getToken;

	// getAuthToken
	public static void authToken() {

		// Read test data from JSON
		String username = TestData("userName");
		String password = TestData("password");
		String payload = "{\n" + " \"username\" :\"" + username + "\",\n" + " \"password\":\"" + password + "\"\n"
				+ "}";
		Response response = given().baseUri("https://restful-booker.herokuapp.com").contentType("application/json")
				.body(payload).when().post("/auth").then().log().all().extract().response();
		getToken = response.jsonPath().getString("token");
		System.out.println("Token:" + getToken);
		HelperClass.API_TOKEN = getToken;
	}

	// Reading TestData from JSON file
	public static String TestData(String value) {
		String strname = " ";
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader(
				System.getProperty("user.dir") + "\\src\\main\\resources\\testDatafiles\\input.json")) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);
			JSONObject input = (JSONObject) obj;
			strname = (String) input.get(value);
			System.out.println(strname);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strname;
	}
}