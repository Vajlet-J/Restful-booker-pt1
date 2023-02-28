package patchRequest;

import config.TestConfig;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class PatchRequest extends TestConfig {

    @Test
    public void partialUpdateRequest(){
        Map<String,Object> map = new HashMap<>();

        JSONObject request = new JSONObject();
         request.put("firstname","Marija");
         request.put("bookingdates", map);
         map.put("checkin","2022-02-01");

         given()
                 .contentType("application/json")
                 .body(request.toJSONString())
         .when()
                 .patch("6218")
         .then()
                 .statusCode(200);

    }
}
