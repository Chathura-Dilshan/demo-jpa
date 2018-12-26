package com.example.jpa.demojpa.restAssuredHelper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class TestGet extends BaseClass {
   private URI uri = new URI("/books/all");

    public TestGet() throws URISyntaxException {
    }


    @Test
    public void testGet() {

        // System.out.println(RestAssured.baseURI+RestAssured.port+RestAssured.basePath);
        Response response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .when()
                .get(uri);
        System.out.println(response.asString());


    }

    @Test
    public void testStatusCode() {
//        int code = RestAssured
//                .given()
//                .accept(ContentType.JSON)
//                .when()
//                .get(uri)
//                .thenReturn()
//                .statusCode();
//        System.out.println(code);

        RestAssured
                .given()
                .accept(ContentType.JSON)
                .when()
                .get(uri)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void testGetWithId() {
        /*
         * Check id 1
         * then status code 200
         * */
        String body = RestAssured
                .given()
                .accept(ContentType.JSON)
                .when()
                .get("/books/1")
                .thenReturn()
                .body()
                .asString();
        System.out.println(body);

//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void testGetWithNonExistId() {
        /*
         * Check id 1
         * then status code 200
         * */
        RestAssured
                .given()
                .accept(ContentType.JSON)
                .when()
                .get("/books/3")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);

    }

    @Test
    public void testGetWithIdWithHeader() {
        /*
         * Custom Header
         * Check id 1
         * then status code 200
         * custom header
         * */
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");


        String body = RestAssured
                .given()
                .headers(headers)
                .when()
                .get("/books/1")
                .thenReturn()
                .body()
                .asString();
        System.out.println(body);


    }

    @Test
    public void testContent() {
        /*
         * */
        RestAssured
                .given()
                .accept(ContentType.JSON)
                .when()
                .get("/books/1")
                .then()
                .body("topics.id",Matchers.hasItems(3));//nested json object eg.
                /*
                * hasItem
                * hasItems
                * hasSize
                *
                * eg.{"id":1,"name":"Book1","author":"author1","topics":[{"id":3,"name":"Topic1","description":"Description1","book":{"id":1,"name":"Book1","author":"author1","price":500.0}}],"price":500.0}
                * */


                /*
                * not nested json objects
                * eg.{"id":"1","name":"Book1"}
                *
                * .body("name", Matchers.equalToIgnoringCase("Book1"),
                        "id",Matchers.equalTo(1),
                        "author",Matchers.equalToIgnoringCase("author1"));*/
    }


}
