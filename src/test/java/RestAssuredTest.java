import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredTest {

    @Test(priority = 1)
    public void test_1() {
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }

    @Test(priority = 2)
    public void test_2() {
        baseURI = "https://reqres.in/api/";
        given().
                get("users?page=2").
                then().
                statusCode(200).body("data[0].id", equalTo(7)).log().all();


    }
}
