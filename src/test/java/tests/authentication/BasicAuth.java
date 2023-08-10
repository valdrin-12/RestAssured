package tests.authentication;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class BasicAuth {

    @DisplayName("GET request with Basic Auth")
    @Test
    public void getRequestWithAuthTest(){

        given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON).and().
                auth().basic("postman","password")

                .when().get("https://postman-echo.com/basic-auth")
        .then().assertThat().statusCode(HttpStatus.SC_OK).and()
                .contentType(ContentType.JSON).and().log().all();


    }
    @DisplayName("Negative GET request with Basic Auth")
    @Test
    public void getRequestWithAuthNegativeTest(){

        given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON).and().
                auth().basic("postman","passwordea")//unathorized

                .when().get("https://postman-echo.com/basic-auth")
                .then().assertThat().statusCode(HttpStatus.SC_UNAUTHORIZED).and()
                .log().all();


    }
}
