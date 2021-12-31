package com.restassured.reqres.test_1_3.tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UsersTest {

    public static final String USERS_BASE_URL = "https://reqres.in/api/users/";
    private static final String ID = "23";

    @Test
    public void getUsersTest(){

        Response response = RestAssured.get(USERS_BASE_URL + ID);

        response.then().assertThat().statusCode(404);
    }
}
