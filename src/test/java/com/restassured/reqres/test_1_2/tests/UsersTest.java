package com.restassured.reqres.test_1_2.tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

/**
 * Test that will get the data of the user where id = 7
 * using this API GET https://reqres.in/api/users/<id>
 * */
public class UsersTest {

    public static final String USERS_BASE_URL = "https://reqres.in/api/users/";
    public static final String RESPONSE_USER_FORMAT = "The user with ID #%s is <%s> <%s>";
    private static final String ID = "7";
    public static final String ID_PATH = "data.id";
    public static final String FIRST_NAME_PATH = "data.first_name";
    public static final String LAST_NAME_PATH = "data.last_name";

    @Test
    public void getUsersTest(){

        Response response = RestAssured.get(USERS_BASE_URL + ID);

        response.then().assertThat().statusCode(200);

        JsonPath path = response.body().jsonPath();

        System.out.printf((RESPONSE_USER_FORMAT) + "%n", path.get(ID_PATH), path.get(FIRST_NAME_PATH), path.get(LAST_NAME_PATH));

    }
}
