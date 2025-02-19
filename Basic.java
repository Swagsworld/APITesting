package org.example;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import payload.PayLoads;

public class Basic {

    public static void main(String[] args)
    {
        RestAssured.baseURI ="https://rahulshettyacademy.com" ;

        String response = given().log().all().queryParam("key","qaclick123")
                .header("Content-Type","application/json").body(PayLoads.fnAddPlace())
                .when().post("/maps/api/place/add/json").then().assertThat().statusCode(200)
                .extract().response().asString();

        System.out.println(response);


        JsonPath js =new JsonPath(response);
        String placeId = js.getString("place_id");
        System.out.println("place_id :" +placeId);


        //update place
        String udAddress = "New York";
        String updateRspns= given().log().all().queryParam("key","qaclick123")
                .header("Content-Type","application/json").body("{\n" +
                        "    \"place_id\": \""+placeId+"\",\n" +
                        "    \"key\": \"qaclick123\",\n" +
                        "    \"address\": \""+udAddress+"\"\n" +
                        "    }").when().put("maps/api/place/update/json").
                then().assertThat().statusCode(200).extract().response().asString();

        System.out.println(updateRspns);

        //get place

        String getRspnse= given().log().all().queryParam("key","qaclick123").
        queryParam("place_id",""+placeId+"")
                .header("Content-Type","application/json").
                when().get("maps/api/place/get/json").
                then().assertThat().statusCode(200).extract().response().asString();
        System.out.println(getRspnse);


        //Assertion validation
        JsonPath jsAddress =new JsonPath(getRspnse);
        String actualAddress = jsAddress.getString("address");
        System.out.println(actualAddress);

        Assert.assertEquals(actualAddress,udAddress);


    }
}
