package deleteRequest;

import config.TestConfig;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class DeleteRequest extends TestConfig {

    @Test
    public void deleteBooking(){
        when()
                .delete("2785")
        .then()
                .statusCode(201);
    }
}
