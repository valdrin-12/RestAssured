package tests.parameters;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.DummyApiTestBase;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PathParamsTests extends DummyApiTestBase {
    @DisplayName("GET single employee")
    @Test
    public void singleEmployeePathParam(){

        response=given().accept(ContentType.JSON)
                .and().pathParam("id",2).when().get("/api/v1/employee/{id}");
        response.prettyPrint();

        assertEquals(HttpStatus.SC_OK,response.statusCode());
        assertEquals("application/json",response.contentType());
        assertTrue(response.asString().contains("Garret"));
    }

    @DisplayName("GET single employee -Path param NEGATIVE test")
    @Test
    public void singleEmployeePathParamNegativeTest(){

        response=given().accept(ContentType.JSON)
                .and().pathParam("id",120000).when().get("/api/v1/employee/{id}");
        response.prettyPrint();

        //assertEquals(HttpStatus.SC_NOT_FOUND,response.statusCode());
        assertEquals("application/json",response.contentType());
        assertTrue(response.asString().contains("null"));
    }


}
