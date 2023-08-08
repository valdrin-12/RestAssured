package tests.requests;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.BoredApiTestBase;

import static io.restassured.RestAssured.given;

public class GetRequestTests extends BoredApiTestBase {

    @DisplayName("Bored Api get request")
    @Test
    public void simpleGetRequest(){
        response=given().accept(ContentType.JSON)
                .when().get("/activity");
        response.prettyPrint();

    }
}
