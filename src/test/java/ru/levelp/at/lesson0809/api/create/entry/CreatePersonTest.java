package ru.levelp.at.lesson0809.api.create.entry;

import com.github.javafaker.Faker;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class CreatePersonTest {

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
            .build();
    }

    @Test
    void createPersonTest() {
        var faker = new Faker();
        var email = faker.internet().emailAddress();
        var firstName = faker.name().firstName();

        RestAssured.given()
                   .spec(requestSpecification())
                   .body("{\n"
                       + "  \"role\": \"LECTOR\",\n"
                       + "  \"email\": \"" + email + "\",\n"
                       + "  \"phoneNumber\": \"+79211234567\",\n"
                       + "  \"placeOfWork\": \"Engineer\",\n"
                       + "  \"identity\": {\n"
                       + "    \"firstName\": \"" + firstName + "\",\n"
                       + "    \"lastName\": \"Pupkin\",\n"
                       + "    \"middleName\": \"Ivanovich\",\n"
                       + "    \"gender\": \"MALE\",\n"
                       + "    \"dateOfBirth\": \"1980-02-07\",\n"
                       + "    \"placeOfBirth\": \"Moscow\",\n"
                       + "    \"passport\": {\n"
                       + "      \"series\": \"1234\",\n"
                       + "      \"number\": \"123456\",\n"
                       + "      \"placeOfIssue\": \"\",\n"
                       + "      \"dateOfIssue\": \"1980-02-07\",\n"
                       + "      \"departmentCode\": \"123-456\"\n"
                       + "    }\n"
                       + "  },\n"
                       + "  \"address\": {\n"
                       + "    \"street\": \"Beethovenstrasse\",\n"
                       + "    \"houseNumber\": 12,\n"
                       + "    \"houseBuilding\": 1,\n"
                       + "    \"houseLetter\": \"A\",\n"
                       + "    \"flat\": 123,\n"
                       + "    \"city\": \"Moscow\",\n"
                       + "    \"postalCode\": \"123456\"\n"
                       + "  }\n"
                       + "}")
                   .when()
                   .post("/people")
                   .then()
                   .spec(responseSpecificationForOkResponse())
                   .body("data.id", Matchers.notNullValue())
                   .body("data.email", Matchers.equalTo(email))
                   .body("data.identity.firstName", Matchers.equalTo(firstName));
    }

    @Test
    void createPersonFromJsonFileTest() throws IOException {
        var faker = new Faker();
        var email = faker.internet().emailAddress();
        var firstName = faker.name().firstName();

        var requestBody = FileUtils
            .readFileToString(new File("src/test/resources/ru/levelp/at/lesson0809/api/requests/createPerson1.json"),
                StandardCharsets.UTF_8)
            .replace("{email}", email)
            .replace("{firstName}", firstName);

        RestAssured.given()
                   .spec(requestSpecification())
                   .body(requestBody)
                   .when()
                   .post("/people")
                   .then()
                   .spec(responseSpecificationForOkResponse())
                   .body("data.id", Matchers.notNullValue())
                   .body("data.email", Matchers.equalTo(email))
                   .body("data.identity.firstName", Matchers.equalTo(firstName));
    }

    @Test
    void createPersonFromJsonFileWithJsonPathTest() throws IOException {
        var faker = new Faker();
        var email = faker.internet().emailAddress();
        var firstName = faker.name().firstName();

        var requestBody = FileUtils
            .readFileToString(new File("src/test/resources/ru/levelp/at/lesson0809/api/requests/createPerson1.json"),
                StandardCharsets.UTF_8);

        String json = JsonPath.parse(requestBody)
                              .set("$.email", email)
                              .set("$.identity.firstName", firstName)
                              .jsonString();

        RestAssured.given()
                   .spec(requestSpecification())
                   .body(json)
                   .when()
                   .post("/people")
                   .then()
                   .spec(responseSpecificationForOkResponse())
                   .body("data.id", Matchers.notNullValue())
                   .body("data.email", Matchers.equalTo(email))
                   .body("data.identity.firstName", Matchers.equalTo(firstName));
    }

    @Test
    void createPersonRequiredFields() throws IOException {
        var faker = new Faker();
        var email = faker.internet().emailAddress();
        var firstName = faker.name().firstName();

        var requestBody = FileUtils
            .readFileToString(new File("src/test/resources/ru/levelp/at/lesson0809/api/requests/createPerson1.json"),
                StandardCharsets.UTF_8);

        String json = JsonPath.parse(requestBody)
                              .delete("$.role")
                              .set("$.email", email)
                              .set("$.identity.firstName", firstName)
                              .jsonString();

        RestAssured.given()
                   .spec(requestSpecification())
                   .body(json)
                   .when()
                   .post("/people")
                   .then()
                   .log().all()
                   .statusCode(400);
    }
}
