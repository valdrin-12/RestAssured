package tests.requests;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReqResApiTests {


    String url="https://reqres.in/api/users";
@DisplayName("Get all users")
    @Test
    public void usersGetTest(){

    Response response=when().get(url);

    response.prettyPrint();
    response.then().statusCode(200);
    assertTrue(response.asString().contains("George"));
    assertTrue(response.contentType().contains("aplication/json"));
}
    @DisplayName("Get single user")
    @Test
    public void usersGetSingleUserApiTest(){

        Response response=when().get(url+"/5");

        response.prettyPrint();
        response.then().statusCode(200);
        assertTrue(response.asString().contains("Charles"));

    }
    @DisplayName("Get single user=Negative Test")
    @Test
    public void usersGetSingleUserApiTestNegativeTest(){

        Response response=when().get(url +"/50");

        response.prettyPrint();
        response.then().statusCode(200);
        assertTrue(response.asString().contains("Charles"));

    }



}
