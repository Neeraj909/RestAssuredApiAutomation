import static io.restassured.RestAssured.*;
import  static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


public class GetAndPostTest {

    @Test(enabled = false)
    public void getFirst(){
        baseURI = "https://reqres.in/api/";
        given().
                get("users?page=2").
                then().
                statusCode(200).
                body("data.first_name",hasItems("Michael","Lindsay"));
    }
    @Test
    public void postTest(){
//        Map<String,String> map=new HashMap<>();
//        map.put("name","neeraj");
//        map.put("job","java");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","neeraj");
        jsonObject.put("job","java");

        baseURI = "https://reqres.in/api/";
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(jsonObject.toJSONString()).
                when().
                post("users").
                then().
                statusCode(201).log().all();

    }
}
