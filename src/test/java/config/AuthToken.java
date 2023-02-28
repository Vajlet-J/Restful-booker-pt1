package config;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class AuthToken {

    public String accessToken;

    public void auth (){
        JSONObject request = new JSONObject();
        request.put("username","admin");
        request.put("password","password123");

        Response response =
                given()
                        .header("Content-Type","application/json")
                        .contentType("application/json")
                        .body(request.toJSONString()).
                when().
                        post("https://restful-booker.herokuapp.com/auth")
                .then()
                        .contentType(ContentType.JSON)
                        .extract().response();

        accessToken = response.jsonPath().getString("token");

    }


}
