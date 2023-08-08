package tests.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelloWorldGetRequest {

String url="https://sandbox.api.service.nhs.uk/hello-world/hello/world";

    @DisplayName("Hello World GET request")
    @Test
    public void helloWorldGetRequestTest(){


        Response response= RestAssured.get(url);
        response.prettyPrint();
        System.out.println(response.asString());

        System.out.println("Status code:"+response.statusCode());
        System.out.println("Status line:"+response.statusLine());

        assertEquals(200,response.statusCode(),"Status code is not 200");
        assertTrue(response.asString().contains("Hello World"),"Status code doesnt contain the string");

    }



}
