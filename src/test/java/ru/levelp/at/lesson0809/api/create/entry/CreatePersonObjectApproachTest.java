package ru.levelp.at.lesson0809.api.create.entry;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.time.LocalDate;
import org.assertj.core.api.SoftAssertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0809.api.model.AddressData;
import ru.levelp.at.lesson0809.api.model.CreatePersonDataRequest;
import ru.levelp.at.lesson0809.api.model.IdentityData;
import ru.levelp.at.lesson0809.api.model.PassportData;
import ru.levelp.at.lesson0809.api.model.PersonResponse;

public class CreatePersonObjectApproachTest {

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
    void createPersonRequestObjectTest() {
        var faker = new Faker();
        var email = faker.internet().emailAddress();
        var firstName = faker.name().firstName();

        var requestBody = CreatePersonDataRequest.builder()
                                                 .role("STUDENT")
                                                 .email(email)
                                                 .phoneNumber(faker.phoneNumber().cellPhone())
                                                 .placeOfWork(faker.company().name())
                                                 .identityData(IdentityData.builder()
                                                                           .firstName(firstName)
                                                                           .lastName(faker.name().lastName())
                                                                           .middleName(faker.name().prefix())
                                                                           .dateOfBirth(LocalDate.now().toString())
                                                                           .gender("FEMALE")
                                                                           .passport(PassportData.builder()
                                                                                             .build())
                                                                           .build())
                                                 .addressData(AddressData.builder()
                                                                         .city(faker.address().city())
                                                                         .postalCode("123321")
                                                                         .street(faker.address().streetName())
                                                                         .houseNumber(10)
                                                                         .houseLetter("F")
                                                                         .flat(123)
                                                                         .build())
                                                 .build();

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
    void createPersonResponseObjectTest() {
        var faker = new Faker();
        var email = faker.internet().emailAddress();
        var firstName = faker.name().firstName();

        var requestBody = CreatePersonDataRequest.builder()
                                                 .role("STUDENT")
                                                 .email(email)
                                                 .phoneNumber(faker.phoneNumber().cellPhone())
                                                 .placeOfWork(faker.company().name())
                                                 .identityData(IdentityData.builder()
                                                                           .firstName(firstName)
                                                                           .lastName(faker.name().lastName())
                                                                           .middleName(faker.name().prefix())
                                                                           .dateOfBirth(LocalDate.now().toString())
                                                                           .gender("FEMALE")
                                                                           .passport(PassportData.builder()
                                                                                             .build())
                                                                           .build())
                                                 .addressData(AddressData.builder()
                                                                         .city(faker.address().city())
                                                                         .postalCode("123321")
                                                                         .street(faker.address().streetName())
                                                                         .houseNumber(10)
                                                                         .houseLetter("F")
                                                                         .flat(123)
                                                                         .build())
                                                 .build();

        PersonResponse responseBody = RestAssured.given()
                                       .spec(requestSpecification())
                                       .body(requestBody)
                                       .when()
                                       .post("/people")
                                       .then()
                                       .spec(responseSpecificationForOkResponse())
                                       .extract()
                                       .as(PersonResponse.class);

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(responseBody.getData().getId()).isNotBlank();
            softly.assertThat(responseBody.getData().getEmail()).isEqualTo(requestBody.getEmail());
            softly.assertThat(responseBody.getData().getRole()).isEqualTo(requestBody.getRole());
            softly.assertThat(responseBody.getData().getIdentity().getDateOfBirth())
                  .isEqualTo(requestBody.getIdentityData().getDateOfBirth());
        });
    }


}
