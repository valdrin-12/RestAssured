package tests.requestBody;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.DummyApiTestBase;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonPathMethod extends DummyApiTestBase {
    Response response;

    @DisplayName("GET us/zipcode- jsonPath")
    @Test
    public void zipCodeJsonPathTest() {

        baseURI = "http://api.zippopotam.us";


        response = given().accept(ContentType.JSON)
                .and().pathParam("country", "us")
                .and().pathParam("postal code", 22102)
                .when().get("/{country/{postal-code}}");
        response.prettyPrint();


        assertEquals(HttpStatus.SC_OK, response.statusCode());
        JsonPath jsonPath = response.jsonPath();

        System.out.println("Country name: " + jsonPath.getString("country"));
        assertEquals("United States", jsonPath.getString("country"));
        System.out.println("Post code : " + jsonPath.getString("'post code'"));

        System.out.println("Place name " + jsonPath.getString("place[0].'place name'"));
        assertEquals("Mc Lean", jsonPath.getString("place[0].'place name'"));
        System.out.println("State" + jsonPath.getString("place[0].state"));
        assertEquals("Virginia", jsonPath.getString("place[0].state"));

        verifyZipCode(jsonPath, "22102");


    }

    @DisplayName("Single employee JsonPAth method")
    @Test
    public void singleEmployeeJsonPathTest() {


        response = given().accept(ContentType.JSON)
                .and().pathParam("id", 6)

                .when().get("/api/v1/employee/{id}");
        response.prettyPrint();


        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertEquals("application/json", response.contentType());

        JsonPath jsonPath = response.jsonPath();

        assertEquals("6", jsonPath.getString("data.id"));

        assertEquals("Brielle Williamson", jsonPath.getString("data.employee_name"));
        assertEquals("3720000", jsonPath.getString("data.employee_salary"));
        assertEquals("61", jsonPath.getString("data.employee_age"));


    }

    public void verifyZipCode(JsonPath jsonPath, String expZipCode) {

        assertEquals(expZipCode, jsonPath.getString("post code"));
    }
}