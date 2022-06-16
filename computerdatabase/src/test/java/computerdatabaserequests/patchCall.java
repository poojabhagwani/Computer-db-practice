package computerdatabaserequests;

import org.junit.jupiter.api.Test;

import com.computerdatabase.model.ComputerPojo;
import com.github.javafaker.Faker;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

public class patchCall extends TestBase {

	// test case to update the computer name of any existing record
	@Test
	void updateRequest() {
		ComputerPojo computer = new ComputerPojo();
		computer.setName("testQA5");
		String parampath = "/574";

		patchCallResponse(computer, parampath).then().statusCode(200);
	}

}
