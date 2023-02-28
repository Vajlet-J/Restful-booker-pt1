package postRequest;

import config.AuthToken;
import config.TestConfig;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class PostRequest extends TestConfig {

    String bodyJSON = "{\n" +
            "    \"firstname\": \"Marta\",\n" +
            "    \"lastname\": \"Smit\",\n" +
            "    \"totalprice\": 120,\n" +
            "    \"depositpaid\": true,\n" +
            "    \"bookingdates\": {\n" +
            "        \"checkin\": \"2022-01-01\",\n" +
            "        \"checkout\": \"2023-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\": \"Breakfast\"\n" +
            "}";


    //1. Create a function for generating an auth token and extracting it to a variable and print it to the console.

    @Test
    public void printToken(){
    AuthToken at = new AuthToken();
        at.auth();
        System.out.println(at.accessToken);

    }

    //2. Create a booking and assert status code

    @Test
    public void createBookingStatusCode(){

        given()
                .contentType(ContentType.JSON)
                .body(bodyJSON)
        .when()
                .post()
        .then()
                .statusCode(200);                                  // po dokumentaciji ocekujem 200 a ne 201
    }

    //3. Create a booking and assert that the response returns payload in the right format.

    @Test
    public void createBookingFormat(){
        given()
                .body(bodyJSON)
        .when()
                .post()
        .then()
                .contentType(ContentType.JSON);
    }
}
