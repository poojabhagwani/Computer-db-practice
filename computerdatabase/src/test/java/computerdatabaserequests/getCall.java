package computerdatabaserequests;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import computerdatabaserequests.TestBase;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class getCall extends TestBase {

	// Test case to get all the data
	@Test
	void requestGet() {
		getCallResponse("", "").then().statusCode(200);

	}

	// Test case to get all the data by searching the name of computer that exists or not
	@Test
	void searchByName() {
		Boolean response = getCallResponse("f", "testQA4").getBody().asString().contains("Nothing to display");

		assertTrue(response, "Nothing to Display message is not appearing");

		getCallResponse("f", "testQA9").then().statusCode(200);
	}

	// Test case to get all the data of a particular page
	@Test
	void getRecordByPage() {
		getCallResponse("p", "2").then().statusCode(200);
	}

	// Test case to get the data of the deleted item
	@Test
	void getInvalidRecord() {
		given().when().get("/576/delete").then().statusCode(404);

	}
}
