package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HrGetsRequests {

    //BeforeAll is a annotation to @BeforeClass in TestNg we use with static method name
    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "http://54.175.31.71:1000/ords/hr";
    }

    @DisplayName("GET request to/regions")
    @Test
    public void test1(){
        Response response = RestAssured.get("/regions");

        System.out.println("response.statusCode() = " + response.statusCode());
    }

    /*

    Given accept type is json
    When user sends get request to /regions/ 2
    Then response status code must be 200
    and body is json format
    and response body contains Americas
     */


}
