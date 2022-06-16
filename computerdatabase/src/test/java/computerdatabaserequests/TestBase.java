package computerdatabaserequests;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.BeforeAll;

import com.computerdatabase.model.ComputerPojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestBase {

	@BeforeAll
	public static void init() {

		RestAssured.baseURI = "http://computer-database.herokuapp.com";
		RestAssured.basePath = "/computers";
	}

	public Response getCallResponse(String paramKey, String paramValue) {
		Response response = given().queryParam(paramKey, paramValue).when().get();
		return response;

	}

	public Response postCallResponse(String payload) {
		Response response = given().when().contentType(ContentType.JSON).when().body(payload).post();
		return response;

	}

	public Response patchCallResponse(ComputerPojo computer, String parampath) {

		Response response = given().when().contentType(ContentType.JSON).when().body(computer).post(parampath);
		return response;

	}

	public Response deleteCallResponse(String parampath) {
		Response response = given().when().contentType("application/x-www-form-urlencoded").post(parampath);
		return response;

	}

}
