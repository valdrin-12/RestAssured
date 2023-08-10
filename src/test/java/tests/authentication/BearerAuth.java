package tests.authentication;

import groovy.json.JsonOutput;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.BookStoreTestBase;

public class BearerAuth extends BookStoreTestBase {

    @DisplayName("Update book with Bearer auth")
    @Test
    public void updateBook(){


        isbn="9781449325865";

        RequestSpecification httpRequest= RestAssured.given().header("Authorization","Bearer"+token)
                .header("Content-Type","application/json");
        response=httpRequest.body("\isbn\:\" +isbn+ "\,\userId\"+userId+"}")." +
            "put(/swagger/BookStore/v1/Book/9781449325865);
    System.out.println("The response code is : "+ response.getStatusCode());
    assertEquals
    }
}
