package tests.requestBody;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Post;
import utilities.DummyApiTestBase;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Deserialization extends DummyApiTestBase {


    String url = "https://jsonplaceholder.typicode.com/posts/1";

    @DisplayName("Single Post Pojo method")
    @Test
    public void singlePostPojoMEthod() {

        response = given().accept(ContentType.JSON)

                .when().get(url);
        response.prettyPrint();
        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertTrue(response.contentType().contains("application/json"));
        Post post = response.as(Post.class);
        assertEquals(1, post.getUserId());
        assertEquals(1, post.getId());
        assertTrue(post.getTitle().contains("sunt aut facere repellat"));
        assertTrue(post.getBody().contains("quia et suscipit"));

    }
}