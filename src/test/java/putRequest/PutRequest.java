package putRequest;

import config.TestConfig;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class PutRequest extends TestConfig {

    @Test
    public void lastNamePutRequest() {
        Map<String, Object> map = new HashMap<>();
        Map<String, String> mapObj = new HashMap<>();

        map.put("firstname", "Marta");
        map.put("lastname", "Marvel");
        map.put("totalprice", 120);
        map.put("depositpaid", true);
        map.put("bookingdates", mapObj);
        mapObj.put("checkin", "2022-01-01");
        mapObj.put("checkout", "2023-01-01");
        map.put("additionalneeds","Breakfast");

        JSONObject request = new JSONObject(map);

        given()
                .contentType("application/json")
                .body(request.toJSONString())
        .when()
                .put("1930")
        .then()
                .statusCode(200);
    }
}
