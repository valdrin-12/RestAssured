package tests.requests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.DummyApiTestBase;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PostRequestTests extends DummyApiTestBase {


    @DisplayName("Create new employee")
   @Test
    public void postEmployeeTest(){

        Map<String ,Object> newEmployee=new HashMap<>();
        newEmployee.put("name","Edison");
        newEmployee.put("salary","10000");
        newEmployee.put("age","30");

        response =given().accept(ContentType.JSON).and().contentType(ContentType.JSON)
                .and().body(newEmployee)
                .when().post("/api/v1/create");
        response.prettyPrint();

        assertEquals(200,response.statusCode());
        assertTrue(response.asString().contains("Succesfully! Record has been added."));
        assertEquals("application/json",response.contentType());



    }
}
