package computerdatabaserequests;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

public class deleteCall extends TestBase {

	// test case to delete a valid record
	@Test
	void deleteRecord() {
		String parampath = "/378/delete";

		deleteCallResponse(parampath).then().statusCode(200);

	}

	// test case to delete a record which does not exists
	@Test
	void deleteInvalidRecord() {

		String parampath = "/501/delete";

		deleteCallResponse(parampath).then().statusCode(200);
	}

}
