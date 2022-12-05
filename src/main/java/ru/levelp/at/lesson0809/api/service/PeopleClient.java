package ru.levelp.at.lesson0809.api.service;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Collections;
import java.util.Map;
import ru.levelp.at.lesson0809.api.model.CreatePersonDataRequest;

public class PeopleClient {

    private static final String PEOPLE_ENDPOINT = "/people";

    private final RequestSpecification requestSpecification;

    public PeopleClient(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public Response createPerson(CreatePersonDataRequest body) {
        return given()
            .spec(requestSpecification)
            .body(body)
            .when()
            .post(PEOPLE_ENDPOINT)
            .andReturn();
    }

    public Response getPeople() {
        return getPeople(Collections.emptyMap());
    }

    public Response getPeople(final Map<String, String> queryParams) {
        return given()
            .spec(requestSpecification)
            .queryParams(queryParams)
            .when()
            .get(PEOPLE_ENDPOINT)
            .andReturn();
    }
}
