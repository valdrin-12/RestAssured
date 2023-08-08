package tests.requests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.BookStoreTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteRequestTests extends BookStoreTestBase {

    @DisplayName("Delete a book")

    @Test

    public void deleteBook() {



        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token)

                .header("Content-Type", "application/json");

        response = httpRequest.body("{ \"isbn\": \"" + isbn + "\", \"userId\": \"" + userId + "\"}")

                .delete("/swagger/BookStore/v1/Book");



        System.out.println("The response code is - " + response.getStatusCode());



        assertEquals(200, response.statusCode());

        assertEquals("text/html; charset=utf-8", response.contentType());

    }
}
