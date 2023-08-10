package tests.hamcrest;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.DummyApiTestBase;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class HamcrestTests extends DummyApiTestBase {

    @DisplayName("GET us/zipcode-HAmcrest")
    @Test
    public void zipcodeHamcrestTest(){

        baseURI = "http://api.zippopotam.us";


       given().accept(ContentType.JSON)
                .and().pathParam("country" ,"us")
                .and().pathParam("postal-code" ,22102)
                .when().get("/{country}/{postal-code}").
               then().assertThat().statusCode(HttpStatus.SC_OK).assertThat()
               .contentType(ContentType.JSON.toString())
               .body("country",is("United States"),
                       "'post code'",is("22102"),
                       "places[0].'place name'",is("Mc Lean"),
                       "places[0].state",is("Virginia"));

    }
    @DisplayName("Single employee Hamcrest Test")
    @Test
    public void SingleHamcrestTest(){



        given().accept(ContentType.JSON)
                .and().pathParam("id" ,10)

                .when().get("/api/v1/employee/{id}").
                then().assertThat().statusCode(HttpStatus.SC_OK).
                assertThat()
                .contentType(ContentType.JSON.toString()).
                body("data.id",is(10),
                        "data.employee_name",
                        is("Sonya Frost"),
                        "data.employee_salary",
                        is(103600),"data.employee_age",
                        is(23));

    }


}
