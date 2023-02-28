package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;

public class TestConfig extends AuthToken{

    @BeforeClass
    public void setup() {

        super.auth();

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com/")
                .setBasePath("booking/")
                .addHeader("Cookie","token=" + accessToken)
                .addHeader("Accept","application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

//        RestAssured.responseSpecification = new ResponseSpecBuilder().log(LogDetail.BODY)
//                .expectStatusCode(200)
//                .expectContentType(ContentType.JSON)
//                .build();
    }


}
