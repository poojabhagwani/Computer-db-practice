package computerdatabaserequests;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class postCall extends TestBase {

	// Test case to create an entry of computer
	@Test
	void createentry() {
		String payload = "{\"name\":\"testQA9\",\"introduced\":\"\",\"discontinued\":\"\",\"company\":\"17\"}";

		postCallResponse(payload).then().statusCode(200);
	}

	// Test case to create an entry of computer by passing no values
	@Test
	void createNullEntry() {

		String payload = " ";

		postCallResponse(payload).then().statusCode(400);

	}

	// Test case to create an entry of computer by passing Invalid format of Introduced date
	@Test
	void createInvalidIntroducedDate() {
		String payload = "{\"name\":\"testABC\",\"introduced\":\"04121994\",\"discontinued\":\"\",\"company\":\"17\"}";
		postCallResponse(payload).then().statusCode(400);
	}

}
