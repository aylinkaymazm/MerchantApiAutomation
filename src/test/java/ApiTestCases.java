import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.CacheRequest;

public class ApiTestCases {

    @Test
    void checkGrocery() {

        Response response = get("https://a19b4e32-1267-44ab-a421-186ff6b27cd5.mock.pstmn.io/allGrocery");

        System.out.println(response.asString());
        System.out.println(response.getBody());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println((response.getTime()));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println(response.getBody().asPrettyString());
    }

    @Test
    void checkGroceryApiTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Grocery expected = mapper.readValue(new File("src/data/AllGrocery.json"), Grocery.class);

        Grocery response = given()
                .when()
                .get("https://a19b4e32-1267-44ab-a421-186ff6b27cd5.mock.pstmn.io/allGrocery")
                .as(Grocery.class);

        Assert.assertEquals(expected.data.size(), response.data.size(), "Actual item number and response's item number are not the same.");
        for (int i = 0; i < expected.data.size(); i++) {
            JsonKeys expectedItem = expected.data.get(i);
            JsonKeys actualItem = response.data.get(i);

            Assert.assertEquals(expectedItem.getId(), actualItem.getId(), "Id not equal");
            Assert.assertEquals(expectedItem.getName(), actualItem.getName(), "Name not equal");
            Assert.assertEquals(expectedItem.getStock(), actualItem.getStock(), "Stock not equal");
            Assert.assertEquals(expectedItem.getPrice(), actualItem.getPrice(), "Prices are not equal");
        }
        System.out.println(response.getBody().asPrettyString());
    }

    @Test
    void checkAppleApiTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Grocery expected = mapper.readValue(new File("src/data/Apple.json"), Grocery.class);

        Grocery response = given()
                .when()
                .get("https://a19b4e32-1267-44ab-a421-186ff6b27cd5.mock.pstmn.io/allGrocery/apple")
                .as(Grocery.class);

        Assert.assertEquals(expected.data.size(), response.data.size(), "Actual item number and response's item number are not the same.");
        for (int i = 0; i < expected.data.size(); i++) {
            JsonKeys expectedItem = expected.data.get(i);
            JsonKeys actualItem = response.data.get(i);

            Assert.assertEquals(expectedItem.getId(), actualItem.getId(), "Id number are not equal");
            Assert.assertEquals(expectedItem.getName(), actualItem.getName(), "Item names are not equal");
            Assert.assertEquals(expectedItem.getStock(), actualItem.getStock(), "Stock numbers are not equal");
            Assert.assertEquals(expectedItem.getPrice(), actualItem.getPrice(), "Prices are not equal");
        }
        System.out.println(response.getBody().asPrettyString());
    }

    @Test
    void checkedGrapesApiTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Grocery expected = mapper.readValue(new File("src/data/Grapes.json"), Grocery.class);

        baseURI = "https://a19b4e32-1267-44ab-a421-186ff6b27cd5.mock.pstmn.io/allGrocery/grapes";
        RequestSpecification httpRequest = given();
        CacheRequest response = null;
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        /*Response response = httpRequest.get("https://a19b4e32-1267-44ab-a421-186ff6b27cd5.mock.pstmn.io/allGrocery/grapes");
        JSONObject obj = new JSONObject(response.then().extract().body().asString());
        JSONArray arr = obj.getJSONArray("grocery");
        JSONObject element;
        for (int i = 0; i < arr.length(); i++) {
            element = arr.getJSONObject(i);
            String id = element.getString("id");
            String name = element.getString("name");
            String price = element.getString("price");
            String stock = element.getString("stock");
            Assert.assertNotEquals(id, null);
            Assert.assertNotEquals(name, null);
            Assert.assertNotEquals(price, null);
            Assert.assertNotEquals(stock, null);
        }*/
        System.out.println(response.getBody().asPrettyString());

        Grocery response = given()
                .when()
                .get("https://a19b4e32-1267-44ab-a421-186ff6b27cd5.mock.pstmn.io/allGrocery/grapes")
                .as(Grocery.class);

        Assert.assertEquals(expected.data.size(), response.data.size(), "Actual item number and response's item number are not the same.");
        for (int i = 0; i < expected.data.size(); i++) {
            JsonKeys expectedItem = expected.data.get(i);
            JsonKeys actualItem = response.data.get(i);

            Assert.assertEquals(expectedItem.getId(), actualItem.getId(), "Id number are not equal");
            Assert.assertEquals(expectedItem.getName(), actualItem.getName(), "Item names are not equal");
            Assert.assertEquals(expectedItem.getStock(), actualItem.getStock(), "Stock numbers are not equal");
            Assert.assertEquals(expectedItem.getPrice(), actualItem.getPrice(), "Prices are not equal");
        }
    }

    @Test
    void checkedNotFoundTest() {
        given()
                .get("https://a19b4e32-1267-44ab-a421-186ff6b27cd5.mock.pstmn.io/allGrocery/pierce")
                .then()
                .statusCode(404);
    }

    @Test
    void checkedBadRequestTest() {
        given()
                .get("https://a19b4e32-1267-44ab-a421-186ff6b27cd5.mock.pstmn.io/allGrocery/watermelon")
                .then()
                .statusCode(400);
    }

    @Test
    void checkedPostTest() {
        given().
                body("{\n" +
                        " \"id\": 4,\n" +
                        " \"name\": \"watermelon\",\n" +
                        " \"price\": 12.3,\n" +
                        " \"stock\": 3\n" +
                        "}").
                when().
                post("https://a19b4e32-1267-44ab-a421-186ff6b27cd5.mock.pstmn.io/allGrocery/add").
                then().
                statusCode(200);


       /* org.json.JSONObject obj = new org.json.JSONObject(response.then().extract().body().asString());
        org.json.JSONArray arr = obj.getJSONArray("data");
        org.json.JSONObject element = arr.getJSONObject(500);
        String content = element.getString("content");
        System.out.println(content);
        Assert.assertEquals(content.trim().length(), 0);
        for (int i = 0; i < arr.length(); i++) {
            element = arr.getJSONObject(i);
            String id = element.getString("id");
            String name = element.getString("name");
            String price = element.getString("price");
            String stock = element.getString("stock");
            Assert.assertNotEquals(id, null);
            Assert.assertNotEquals(name, null);
            Assert.assertNotEquals(price, null);
            Assert.assertNotEquals(stock, null);
        }*/
        System.out.println(response.getBody().asPrettyString());
    }
}

