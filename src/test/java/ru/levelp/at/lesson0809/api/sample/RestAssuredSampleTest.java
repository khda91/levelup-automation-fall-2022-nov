package ru.levelp.at.lesson0809.api.sample;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class RestAssuredSampleTest {

    @Test
    void getMessengers() {
        // given
        // when
        // then

        RestAssured.when()
                   .get("http://localhost:8080/srv-person-profile/messengers")
                   .then()
                   .statusCode(200);
    }

    @Test
    void getMessengersWithLogs() {
        // given
        // when
        // then

        RestAssured.given()
                   .log().all()
                   .when()
                   .get("http://localhost:8080/srv-person-profile/messengers")
                   .then()
                   .log().all()
                   .statusCode(200);
    }

    @Test
    void getMessengersAssertDataInBody() {
        RestAssured.given()
                   .log().all()
                   .when()
                   .get("http://localhost:8080/srv-person-profile/messengers")
                   .then()
                   .log().all()
                   .statusCode(200)
                   .body("data.id", Matchers.containsInAnyOrder("ICQ", "WHATS_UP", "VIBER", "TELEGRAM"))
                   .body("meta.pagination.limit", Matchers.equalTo(10))
                   .body("meta.pagination.offset", Matchers.equalTo(0))
                   .body("meta.pagination.totalCount", Matchers.equalTo(4));
    }

    @Test
    void addMessenger() {
        Faker faker = new Faker();
        String messengerName = faker.beer().name().toUpperCase().replaceAll(" ", "_");

        RestAssured.given()
                   .log().all()
                   .when()
                   .put("http://localhost:8080/srv-person-profile/messengers/" + messengerName)
                   .then()
                   .log().all()
                   .statusCode(204);

        RestAssured.given()
                   .log().all()
                   .when()
                   .get("http://localhost:8080/srv-person-profile/messengers")
                   .then()
                   .log().all()
                   .statusCode(200)
                   .body("data.id", Matchers.hasItem(messengerName))
                   .body("meta.pagination.totalCount", Matchers.equalTo(5));
    }

    @Test
    void addMessengerWithInvalidName() {
        Faker faker = new Faker();
        String messengerName = faker.beer().name();

        RestAssured.given()
                   .log().all()
                   .when()
                   .put("http://localhost:8080/srv-person-profile/messengers/" + messengerName)
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
                   .put("http://localhost:8080/srv-person-profile/messengers/" + messengerName)
                   .then()
                   .log().all()
                   .statusCode(400)
                   .body("type", Matchers.equalTo("validation1"),
                       "title", Matchers.equalTo("Bad Request1"),
                       "status", Matchers.equalTo("422"),
                       "violations", Matchers.hasSize(1));
    }

    @Test
    void addMessengerWithInvalidNamePathParams() {
        Faker faker = new Faker();
        String messengerName = faker.beer().name();

        RestAssured.given()
                   .log().all()
                   .pathParam("messengerId", messengerName)
                   .when()
                   .put("http://localhost:8080/srv-person-profile/messengers/{messengerId}")
                   .then()
                   .log().all()
                   .statusCode(400)
                   .body("type", Matchers.equalTo("validation1"),
                       "title", Matchers.equalTo("Bad Request1"),
                       "status", Matchers.equalTo("422"),
                       "violations", Matchers.hasSize(1));
    }
}
