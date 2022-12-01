package ru.levelp.at.lesson0809.api.configuration;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class RestAssuredSpecificationTest {

    RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(8080)
            .setBasePath("srv-person-profile")
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();
    }

    ResponseSpecification responseSpecificationForOkResponse() {
        return new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectStatusCode(200)
            .build();
    }

    ResponseSpecification responseSpecificationForBadRequestResponse() {
        return new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectStatusCode(HttpStatus.SC_BAD_REQUEST)
            .expectBody("type", Matchers.equalTo("validation"))
            .expectBody("title", Matchers.equalTo("Bad Request"))
            .expectBody("status", Matchers.equalTo("400"))
            .expectBody("violations", Matchers.hasSize(1))
            .build();
    }

    @Test
    void getMessengersWithLogs() {
        RestAssured.given()
                   .spec(requestSpecification())
                   .when()
                   .get("/messengers")
                   .then()
                   .spec(responseSpecificationForOkResponse());
    }

    @Test
    void getMessengersAssertDataInBody() {
        RestAssured.given()
                   .spec(requestSpecification())
                   .when()
                   .get("/messengers")
                   .then()
                   .spec(responseSpecificationForOkResponse())
                   .body("data.id", Matchers.hasItems("ICQ", "WHATS_UP", "VIBER", "TELEGRAM"));
    }

    @Test
    void addMessenger() {
        Faker faker = new Faker();
        String messengerName = faker.beer().name().toUpperCase().replaceAll(" ", "_");

        RestAssured.given()
                   .spec(requestSpecification())
                   .pathParam("messengerId", messengerName)
                   .when()
                   .put("/messengers/{messengerId}")
                   .then()
                   .log().all()
                   .statusCode(204);

        RestAssured.given()
                   .spec(requestSpecification())
                   .when()
                   .get("/messengers")
                   .then()
                   .spec(responseSpecificationForOkResponse())
                   .body("data.id", Matchers.hasItem(messengerName));
    }

    @Test
    void addMessengerWithInvalidName() {
        Faker faker = new Faker();
        String messengerName = faker.beer().name();

        RestAssured.given()
                   .spec(requestSpecification())
                   .pathParam("messengerId", messengerName)
                   .when()
                   .put("/messengers/{messengerId}")
                   .then()
                   .spec(responseSpecificationForBadRequestResponse());
    }

    @Test
    void addSocialNetworkWithInvalidName() {
        Faker faker = new Faker();
        String socialNetworkName = faker.beer().name();

        RestAssured.given()
                   .spec(requestSpecification())
                   .pathParam("socialNetworkId", socialNetworkName)
                   .when()
                   .put("/social-networks/{socialNetworkId}")
                   .then()
                   .spec(responseSpecificationForBadRequestResponse());
    }

    @Test
    void addMessengerWithInvalidNameSoftAssertion() {
        Faker faker = new Faker();
        String messengerName = faker.beer().name();

        RestAssured.given()
                   .spec(requestSpecification())
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
                   .spec(requestSpecification())
                   .pathParam("socialNetworkId", socialNetworkName)
                   .when()
                   .put("/social-networks/{socialNetworkId}")
                   .then()
                   .log().all()
                   .statusCode(204);

        RestAssured.given()
                   .spec(requestSpecification())
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
                   .spec(requestSpecification())
                   .contentType(ContentType.JSON)
                   .when()
                   .delete("/people/{personId}/social-network/{socialNetworkId}",
                       "ec9655d2-e35d-4f45-be81-7ed4abc7cdc9", socialNetworkName)
                   .then()
                   .log().all()
                   .statusCode(204);

        RestAssured.given()
                   .spec(requestSpecification())
                   .pathParam("personId", "ec9655d2-e35d-4f45-be81-7ed4abc7cdc9")
                   .contentType(ContentType.JSON)
                   .when()
                   .get("/people/{personId}/social-network")
                   .then()
                   .spec(responseSpecificationForOkResponse())
                   .body("data.socialNetworkId", Matchers.not(Matchers.hasItem(socialNetworkName)));
    }
}
