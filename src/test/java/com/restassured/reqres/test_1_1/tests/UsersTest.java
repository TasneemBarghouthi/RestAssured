package com.restassured.reqres.test_1_1.tests;

import com.restassured.reqres.test_1_1.model.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

/**
 * Test to create a user using this API
 * POST https://reqres.in/api/users
 *
 * */
public class UsersTest {

    public static final String USERS_BASE_URL = "https://reqres.in/api/users/";
    public static final String NAME = "NAME";
    public static final String JOB = "JOB";
    private static final String RESPONSE_ID_FORMAT = "The returned id is <%s>";

    @Test
    public void createUserTest(){

        User user = new User(NAME, JOB);

        Response response = RestAssured
                .given()
                .body(user)
                .post(USERS_BASE_URL);

        response.then().assertThat().statusCode(201);

        int id = response.body().as(User.class).getId();

        System.out.printf((RESPONSE_ID_FORMAT) + "%n", id);

    }
}
