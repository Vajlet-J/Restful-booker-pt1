package getRequest;

import config.TestConfig;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetRequest extends TestConfig {

    //   1. Assert that all booking id's return status code 200

    @Test
    public void statusCodeAssertation(){
        given()
        .when()
                .get()
        .then()
                .statusCode(200);
    }

    //  2. Assert that booking id's are not an empty array.

    @Test
    public void emptyArrayAssertation(){
        given()
        .when()
                .get()
        .then()
                .body("bookingid",not(emptyArray()));

    }

    //  3. Assert that booking id's filtered by name return status code 200

    @Test
    public void filteredByNameAssertation(){
        given()
        .when()
                .get("4463")
        .then()
                .body("firstname",containsString("Josh"))
                .statusCode(200);
    }

    //  4. Assert that booking id's filtered by date return status code 200

    @Test
    public void filteredByDateAssertation(){
        given()
        .when()
                .get("9008")
        .then()
                .body("bookingdates.checkin",equalTo("2018-01-01"))
                .statusCode(200);

    }
    //  5. Assert that booking id return status code 200

    @Test
    public void idStatusCodeAssertation(){
        given()
        .when()
                .get("4463")
        .then()
                .statusCode(200);
    }
}
