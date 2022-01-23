import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PutAndPatch {
    @Test
    public void putTest(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","neeraj");
        jsonObject.put("job","java");

        baseURI = "https://reqres.in/api/";
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(jsonObject.toJSONString()).
                when().
                put("users/2").
                then().
                statusCode(200).log().all();
    }
    @Test
    public void patchTest(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","neeraj");

        baseURI = "https://reqres.in/api/";
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(jsonObject.toJSONString()).
                when().
                patch("users/2").
                then().
                statusCode(200).log().all();
    }
    @Test
    public void deleteTest(){
        baseURI = "https://reqres.in/api/";
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                when().
                delete("users/2").
                then().
                statusCode(204).log().all();
    }
}
