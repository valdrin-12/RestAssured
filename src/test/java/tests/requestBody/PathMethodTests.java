package tests.requestBody;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.DummyApiTestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathMethodTests extends DummyApiTestBase {

    @DisplayName("GET employee data: PAth method")
    @Test
    public void getAllEmployeeDataPathAMethod(){

        response = given().accept(ContentType.JSON)

                .when().get("/api/v1/employees");
        response.prettyPrint();

        List<String> actNames=response.path("data.employee_name");

        List<String> expNames = new ArrayList<>();

        expNames.addAll(Arrays.asList("Tiger Nixon", "Garrett Winters", "Ashton Cox", "Cedric Kelly", "Airi Satou",

                "Brielle Williamson", "Herrod Chandler", "Rhona Davidson", "Colleen Hurst", "Sonya Frost",

                "Jena Gaines", "Quinn Flynn", "Charde Marshall", "Haley Kennedy", "Tatyana Fitzpatrick", "Michael Silva",

                "Paul Byrd", "Gloria Little", "Bradley Greer", "Dai Rios", "Jenette Caldwell", "Yuri Berry", "Caesar Vance", "Doris Wilder"));



        List<Integer> expSalaries = new ArrayList<>();

        expSalaries.addAll(Arrays.asList(320800, 170750, 86000, 433060, 162700, 372000, 137500, 327900, 205500, 103600, 90560, 342000, 470600, 313500, 385750, 198500, 725000, 237500, 132000, 217500, 345000, 675000, 106450, 85600));
        List<Integer> actSalaries=response.path("data.employee_salary");

        assertEquals(200, HttpStatus.SC_OK);
       assertEquals("application/json",ContentType.JSON.toString());
       assertEquals(expNames,actNames);
       assertEquals(expSalaries,actSalaries);


    }
    @DisplayName("GET single employee data: PAth method")
    @Test
    public void getSingleEmployeeDataPathAMethod(){

        response = given().accept(ContentType.JSON)

                .when().get("/api/v1/employees");
        Object data =response.path("data[2]");
        System.out.println(data);

        String expName="Ashton Cox";
        Integer expId=3;
        Integer expSalary=86000;
        Integer expAge=66;

        assertEquals(200, HttpStatus.SC_OK);
        assertEquals("application/json",ContentType.JSON.toString());
        assertEquals(expName,response.path("data.employee_name[2]"));
        assertEquals(expSalary,response.path("data.employee_salary[2]"));
        assertEquals(expAge,response.path("data.employee_age[2]"));



    }
}
