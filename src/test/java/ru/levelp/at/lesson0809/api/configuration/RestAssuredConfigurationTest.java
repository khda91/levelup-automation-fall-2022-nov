package ru.levelp.at.lesson0809.api.configuration;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RestAssuredConfigurationTest {

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "srv-person-profile";
        //        var authorization = new BasicAuthScheme();
        //        authorization.setUserName("user");
        //        authorization.setPassword("user");
        //        RestAssured.authentication = authorization;
    }

    @Test
    void getMessengersWithLogs() {
        RestAssured.given()
                   .log().all()
                   .when()
                   .get("/messengers")
                   .then()
                   .log().all()
                   .statusCode(200);
    }

    @Test
    void getMessengersAssertDataInBody() {
        RestAssured.given()
                   .log().all()
                   .when()
                   .get("/messengers")
                   .then()
                   .log().all()
                   .statusCode(200)
                   .body("data.id", Matchers.hasItems("ICQ", "WHATS_UP", "VIBER", "TELEGRAM"));
    }

    @Test
    void addMessenger() {
        Faker faker = new Faker();
        String messengerName = faker.beer().name().toUpperCase().replaceAll(" ", "_");

        RestAssured.given()
                   .log().all()
                   .pathParam("messengerId", messengerName)
                   .when()
                   .put("/messengers/{messengerId}")
                   .then()
                   .log().all()
                   .statusCode(204);

        RestAssured.given()
                   .log().all()
                   .when()
                   .get("/messengers")
                   .then()
                   .log().all()
                   .statusCode(200)
                   .body("data.id", Matchers.hasItem(messengerName));
    }

    @Test
    void addMessengerWithInvalidName() {
        Faker faker = new Faker();
        String messengerName = faker.beer().name();

        RestAssured.given()
                   .log().all()
                   .when()
                   .put("/messengers/")
                   .then()
                   .log().all()
                   .statusCode(400)
                   .body("type", Matchers.equalTo("validation"))
                   .body("title", Matchers.equalTo("Bad Request"))
                   .body("status", Matchers.equalTo("400"))
                   .body("violations", Matchers.hasSize(1));
    }

    @Test
    void addMessengerWithInvalidNameSoftAssertion() {
        Faker faker = new Faker();
        String messengerName = faker.beer().name();

        RestAssured.given()
                   .log().all()
                   .when()
                   .put("/messengers/" + messengerName)
                   .then()
                   .log().all()
                   .statusCode(400)
                   .body("type", Matchers.equalTo("validation"),
                       "title", Matchers.equalTo("Bad Request"),
                       "status", Matchers.equalTo("400"),
                       "violations", Matchers.hasSize(1));
    }

    @Test
    void deleteMessengerFromPerson() {
        Faker faker = new Faker();
        String socialNetworkName = faker.buffy().bigBads().toUpperCase().replaceAll(" ", "_");

        RestAssured.given()
                   .log().all()
                   .pathParam("socialNetworkId", socialNetworkName)
                   .when()
                   .put("/social-networks/{socialNetworkId}")
                   .then()
                   .log().all()
                   .statusCode(204);

        RestAssured.given()
                   .log().all()
                   .pathParam("personId", "ec9655d2-e35d-4f45-be81-7ed4abc7cdc9")
                   .body("{\n"
                       + "  \"socialNetworkId\": \"" + socialNetworkName + "\",\n"
                       + "  \"link\": \"https://sn.com/id_" + socialNetworkName + "\"\n"
                       + "}")
                   .contentType(ContentType.JSON)
                   .when()
                   .post("/people/{personId}/social-network")
                   .then()
                   .log().all()
                   .statusCode(201);

        RestAssured.given()
                   .log().all()
                   .contentType(ContentType.JSON)
                   .when()
                   .delete("/people/{personId}/social-network/{socialNetworkId}",
                       "ec9655d2-e35d-4f45-be81-7ed4abc7cdc9", socialNetworkName)
                   .then()
                   .log().all()
                   .statusCode(204);

        RestAssured.given()
                   .log().all()
                   .pathParam("personId", "ec9655d2-e35d-4f45-be81-7ed4abc7cdc9")
                   .contentType(ContentType.JSON)
                   .when()
                   .get("/people/{personId}/social-network")
                   .then()
                   .log().all()
                   .statusCode(200)
                   .body("data.socialNetworkId", Matchers.not(Matchers.hasItem(socialNetworkName)));
    }
}
