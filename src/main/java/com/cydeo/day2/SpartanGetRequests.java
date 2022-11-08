package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpartanGetRequests {
    String baseUrl ="http://54.175.31.71:8000";

//Given accept type application/json
//When user send GET request to api/spartans end point
//And status code must be 200
//Then response Content TYpe must be application/json
//And response body should include spartan result

    @Test
    public void Test1(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when()
                     .get(baseUrl+"/api/spartans");

        //printing status code from object
        System.out.println("response.statusCode() = " + response.statusCode());

        //printing response content type from response object
        System.out.println("response.contentType() = " + response.contentType());

        //print whole result body
        response.prettyPrint();

        //how to API testing  then?
        //verify status code is 200
        Assertions.assertEquals(response.statusCode(),200);

        //verify content type is application/json
        Assertions.assertEquals(response.contentType(),"application/json");

    }

    //Given accept type application/json
//When user send GET request to api/spartans/3
//And status code must be 200
//Then response Content TYpe must be application/json
//And response body should contain Fidale

    @DisplayName("Get one spartan/api/spartans/3 and verify")
    @Test
    public void Test2(){
        Response response= RestAssured.given().accept(ContentType.JSON).
                when().get(baseUrl+"/api/spartans/3");


        //verify status code 200
        Assertions.assertEquals(response.statusCode(),200);

        //verify content type
        Assertions.assertEquals(response.contentType(),"application/json");
        Assertions.assertTrue(response.body().asString().contains("Fidole"));
    }
    /*
    Given no headers provided
    When users send GET request to /api/hello
    Then response status code should be 200
    And Content type header should be "text/plain: charset=UTF-8"
    And header should contain date
    And Content Length should be 17
    And body should be "Hello from Sparta"
     */
    @DisplayName("Get request to /api/hello")
    @Test
    public void test3(){
        //send request and save response inside the response object
       Response response =  RestAssured.when().get(baseUrl+"/api/hello");

       //verify status code 200
        Assertions.assertEquals(200,response.statusCode());

        //verify content type
        Assertions.assertEquals("text/plain;charset=UTF-8",response.contentType());

        //verify we  have headers named date
        //we use hasHeaderWithName method to verify header exist or not
       Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));

       // how to get and header from response  using header key?
        //we use response.header(String headerName) method to get any header value
        System.out.println("response.header(\"Content-Length\") = " + response.header("Content-Length"));
        System.out.println(response.header("Date"));

         //verify content length is 17
        Assertions.assertEquals("17",response.header("Content-Length"));

        //verify body is "Hello from Sparta"
        Assertions.assertEquals("Hello from Sparta",response.body().asString());



    }


}
