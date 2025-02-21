package org.example;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.File;

import static io.restassured.RestAssured.given;

public class JIRATest {

    public static void main(String[] args)
    {
        RestAssured.baseURI = "https://swagsworld1986.atlassian.net/";

        String createBug = given().log().all().header("Content-Type","application/json").
                header("Authorization","Basic c3dhZ3N3b3JsZDE5ODZAZ21haWwuY29tOkFUQVRUM3hGZkdGMEhZSzFhcTdkMTFwUnZ4eDlLZXNjWVU3eHBDdHBzaDZiSExITFcwV3dNZ1doYmstZF9yc3VkY2FXWjRWSndpQXpQYW93bFA1SGJpLWxZcnhFSUxfMklmV2ZZWEdJSS1XWEZPb3ZWdjRjN0xRYkszTC1XbXU0N3BremNUd2FVeXllOFFBRk9ONjVjd3BvMm9GbUloZGh0Nk1wQnhEb201YXB6MnVHZ09yd3BJND0yNDU1MUNCOQ==").
                body("{\n" +
                        "    \"fields\":{\n" +
                        "        \"project\":{\n" +
                        "            \"key\": \"SCRUM\"\n" +
                        "        },\n" +
                        "        \"summary\":\"Automation\",\n" +
                        "        \"description\":\"Created by Automation-21st Feb-1:22 PM\",\n" +
                        "        \"issuetype\":{\n" +
                        "            \"name\": \"Bug\"\n" +
                        "        }\n" +
                        "    }\n" +
                        "}").log().all().
                when().post("rest/api/2/issue").
                then().assertThat().statusCode(201).extract().response().asString();

        System.out.println(createBug);

        JsonPath js = new JsonPath(createBug);
        String issueId = js.getString("id");

        System.out.println("Bug number is " +issueId);

        //Attaching screenshot

        String addAttchmnt = given().log().all().
                pathParam("key",issueId).header("X-Atlassian-Token","no-check").
                header("Authorization","Basic c3dhZ3N3b3JsZDE5ODZAZ21haWwuY29tOkFUQVRUM3hGZkdGMEhZSzFhcTdkMTFwUnZ4eDlLZXNjWVU3eHBDdHBzaDZiSExITFcwV3dNZ1doYmstZF9yc3VkY2FXWjRWSndpQXpQYW93bFA1SGJpLWxZcnhFSUxfMklmV2ZZWEdJSS1XWEZPb3ZWdjRjN0xRYkszTC1XbXU0N3BremNUd2FVeXllOFFBRk9ONjVjd3BvMm9GbUloZGh0Nk1wQnhEb201YXB6MnVHZ09yd3BJND0yNDU1MUNCOQ==")
                .multiPart("file",new File("C://Users//swaga_ym2doud//Downloads//JIRA Ref1.png")).log().all().
                when().post("rest/api/3/issue/{key}/attachments").
                then().assertThat().statusCode(200).extract().response().asString();

        System.out.println(addAttchmnt);
    }
}






