package ru.levelp.at.taf.service.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.Map;
import ru.levelp.at.taf.configuration.WebAppConfig;

import static io.restassured.RestAssured.given;

public class TrelloBoardsClient {

    private static final String BOARDS_ENDPOINT = "/boards";

    private static final String URL;
    private static final String BASE_PATH;
    private static final String API_KEY;
    private static final String API_TOKEN;

    static {
        var config = WebAppConfig.getInstance();
        URL = config.apiUrl();
        BASE_PATH = config.basePath();
        API_KEY = config.apiKey();
        API_TOKEN = config.apiToken();
    }

    private final RequestSpecification requestSpecification;
    private final ResponseSpecification responseSpecification;

    public TrelloBoardsClient() {
        this.requestSpecification = new RequestSpecBuilder()
            .setBaseUri(URL)
            .setBasePath(BASE_PATH)
            .addQueryParams(Map.of(
                "key", API_KEY,
                "token", API_TOKEN
            ))
            .setContentType(ContentType.JSON)
            .build();
        this.responseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();
    }

    public Response createBoard(final String name) {
        return given()
            .spec(requestSpecification)
            .queryParam("name", name)
            .when()
            .post(BOARDS_ENDPOINT)
            .then()
            .spec(responseSpecification)
            .extract().response();
    }
}
