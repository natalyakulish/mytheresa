package com.github;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertThat;

public class GetGithubTest {
    @Test
    public void getGithub() {

        RestAssured.baseURI = "https://api.github.com/";

        final Response response = given().params("q", "tetris language:assembly", "sort", "stars", "order", "d")
                .when().get("search/repositories");
        response.then().statusCode(200);

        final JsonPath jsonPath = response.then().extract().body().jsonPath();

        final Integer totalCount = jsonPath.get("total_count");
        final List items = jsonPath.getList("items");
        final Boolean incompleteResults = jsonPath.get("incomplete_results");


        assertThat(totalCount, CoreMatchers.notNullValue());
        assertThat(items, CoreMatchers.notNullValue());
        assertThat(incompleteResults, CoreMatchers.notNullValue());

    }
}
