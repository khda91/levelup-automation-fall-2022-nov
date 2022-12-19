package ru.levelp.at.lesson1011.allure.api;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.levelp.at.lesson1011.allure.api.model.AddressData;
import ru.levelp.at.lesson1011.allure.api.model.CreatePersonDataRequest;
import ru.levelp.at.lesson1011.allure.api.model.IdentityData;
import ru.levelp.at.lesson1011.allure.api.model.PassportData;
import ru.levelp.at.lesson1011.allure.api.model.PersonListResponse;
import ru.levelp.at.lesson1011.allure.api.model.PersonResponse;
import ru.levelp.at.lesson1011.allure.api.model.ProblemResponse;
import ru.levelp.at.lesson1011.allure.api.model.Violation;
import ru.levelp.at.lesson1011.allure.api.service.PeopleClient;

class PeopleServiceTest {

    static Stream<Arguments> limitQueryParameterDataProvider() {
        return Stream.of(
            Arguments.of(Map.of("limit", "1")),
            Arguments.of(Map.of("limit", "9"))
        );
    }

    static Stream<Arguments> createPersonNegativeDataProvider() {
        final var faker = new Faker();

        return Stream.of(
            Arguments.of(CreatePersonDataRequest.builder()
                                                .placeOfWork(faker.company().name())
                                                .identityData(IdentityData.builder()
                                                                          .firstName(faker.name().firstName())
                                                                          .lastName(faker.name().lastName())
                                                                          .middleName(faker.name().prefix())
                                                                          .dateOfBirth(LocalDate.now().toString())
                                                                          .gender("FEMALE")
                                                                          .passport(PassportData.builder().build())
                                                                          .build())
                                                .addressData(
                                                    AddressData.builder()
                                                               .city(faker.address().city())
                                                               .postalCode("123321")
                                                               .street(faker.address().streetName())
                                                               .houseNumber(10)
                                                               .houseLetter("F")
                                                               .flat(123)
                                                               .build())
                                                .email(faker.internet().emailAddress())
                                                .phoneNumber(faker.phoneNumber().cellPhone())
                                                .build(), "role"),
            Arguments.of(CreatePersonDataRequest.builder()
                                                .placeOfWork(faker.company().name())
                                                .identityData(IdentityData.builder()
                                                                          .firstName(faker.name().firstName())
                                                                          .lastName(faker.name().lastName())
                                                                          .middleName(faker.name().prefix())
                                                                          .dateOfBirth(LocalDate.now().toString())
                                                                          .gender("FEMALE")
                                                                          .passport(PassportData.builder().build())
                                                                          .build())
                                                .addressData(
                                                    AddressData.builder()
                                                               .city(faker.address().city())
                                                               .postalCode("123321")
                                                               .street(faker.address().streetName())
                                                               .houseNumber(10)
                                                               .houseLetter("F")
                                                               .flat(123)
                                                               .build())
                                                .role("STUDENT")
                                                .phoneNumber(faker.phoneNumber().cellPhone())
                                                .build(), "email"),
            Arguments.of(CreatePersonDataRequest.builder()
                                                .placeOfWork(faker.company().name())
                                                .identityData(IdentityData.builder()
                                                                          .firstName(faker.name().firstName())
                                                                          .lastName(faker.name().lastName())
                                                                          .middleName(faker.name().prefix())
                                                                          .dateOfBirth(LocalDate.now().toString())
                                                                          .gender("FEMALE")
                                                                          .passport(PassportData.builder().build())
                                                                          .build())
                                                .addressData(
                                                    AddressData.builder()
                                                               .city(faker.address().city())
                                                               .postalCode("123321")
                                                               .street(faker.address().streetName())
                                                               .houseNumber(10)
                                                               .houseLetter("F")
                                                               .flat(123)
                                                               .build())
                                                .role("STUDENT")
                                                .email(faker.internet().emailAddress())
                                                .build(), "phoneNumber")
        );
    }

    static Stream<Arguments> createPersonNegativeWithInvalidEmailDataProvider() {
        final var faker = new Faker();

        return Stream.of(
            Arguments.of(CreatePersonDataRequest.builder()
                                                .placeOfWork(faker.company().name())
                                                .identityData(IdentityData.builder()
                                                                          .firstName(faker.name().firstName())
                                                                          .lastName(faker.name().lastName())
                                                                          .middleName(faker.name().prefix())
                                                                          .dateOfBirth(LocalDate.now().toString())
                                                                          .gender("FEMALE")
                                                                          .passport(PassportData.builder().build())
                                                                          .build())
                                                .addressData(
                                                    AddressData.builder()
                                                               .city(faker.address().city())
                                                               .postalCode("123321")
                                                               .street(faker.address().streetName())
                                                               .houseNumber(10)
                                                               .houseLetter("F")
                                                               .flat(123)
                                                               .build())
                                                .email(faker.internet().emailAddress())
                                                .phoneNumber(faker.phoneNumber().cellPhone())
                                                .build(),
                Violation.builder()
                         .code("missing_field")
                         .field("CreatePersonData.role")
                         .detail("must not be null")
                         .build()),
            Arguments.of(CreatePersonDataRequest.builder()
                                                .placeOfWork(faker.company().name())
                                                .identityData(IdentityData.builder()
                                                                          .firstName(faker.name().firstName())
                                                                          .lastName(faker.name().lastName())
                                                                          .middleName(faker.name().prefix())
                                                                          .dateOfBirth(LocalDate.now().toString())
                                                                          .gender("FEMALE")
                                                                          .passport(PassportData.builder().build())
                                                                          .build())
                                                .addressData(
                                                    AddressData.builder()
                                                               .city(faker.address().city())
                                                               .postalCode("123321")
                                                               .street(faker.address().streetName())
                                                               .houseNumber(10)
                                                               .houseLetter("F")
                                                               .flat(123)
                                                               .build())
                                                .role("STUDENT")
                                                .phoneNumber(faker.phoneNumber().cellPhone())
                                                .build(),
                Violation.builder()
                         .code("missing_field")
                         .field("CreatePersonData.email")
                         .detail("must not be null")
                         .build()),
            Arguments.of(CreatePersonDataRequest.builder()
                                                .placeOfWork(faker.company().name())
                                                .identityData(IdentityData.builder()
                                                                          .firstName(faker.name().firstName())
                                                                          .lastName(faker.name().lastName())
                                                                          .middleName(faker.name().prefix())
                                                                          .dateOfBirth(LocalDate.now().toString())
                                                                          .gender("FEMALE")
                                                                          .passport(PassportData.builder().build())
                                                                          .build())
                                                .addressData(
                                                    AddressData.builder()
                                                               .city(faker.address().city())
                                                               .postalCode("123321")
                                                               .street(faker.address().streetName())
                                                               .houseNumber(10)
                                                               .houseLetter("F")
                                                               .flat(123)
                                                               .build())
                                                .role("STUDENT")
                                                .email(faker.internet().emailAddress())
                                                .build(),
                Violation.builder()
                         .code("missing_field")
                         .field("CreatePersonData.phoneNumber")
                         .detail("must not be null")
                         .build()),
            Arguments.of(CreatePersonDataRequest.builder()
                                                .placeOfWork(faker.company().name())
                                                .identityData(IdentityData.builder()
                                                                          .firstName(faker.name().firstName())
                                                                          .lastName(faker.name().lastName())
                                                                          .middleName(faker.name().prefix())
                                                                          .dateOfBirth(LocalDate.now().toString())
                                                                          .gender("FEMALE")
                                                                          .passport(PassportData.builder().build())
                                                                          .build())
                                                .addressData(
                                                    AddressData.builder()
                                                               .city(faker.address().city())
                                                               .postalCode("123321")
                                                               .street(faker.address().streetName())
                                                               .houseNumber(10)
                                                               .houseLetter("F")
                                                               .flat(123)
                                                               .build())
                                                .role("STUDENT")
                                                .email(faker.internet().password())
                                                .phoneNumber(faker.phoneNumber().cellPhone())
                                                .build(),
                Violation.builder()
                         .code("invalid_field")
                         .field("CreatePersonData.email")
                         .detail("Provided email has incorrect format. Email should match with the patten: "
                             + "^(?i)[a-z0-9!#$%&'*+\\-/=?^_`{|}~]+(\\.[a-z0-9!#$%&'*+\\-/=?^_`{|}~]+)"
                             + "*@[a-z0-9-]{1,63}(\\.[a-z0-9-]{1,63})+$")
                         .build())
        );
    }

    @BeforeAll
    static void beforeAll() {
        RestAssured.filters(new AllureRestAssured());
    }

    RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(8082)
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

        PersonResponse responseBody = new PeopleClient(requestSpecification())
            .createPerson(requestBody)
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

    @Test
    void getPeopleTest() {
        var responseBody = new PeopleClient(requestSpecification()).getPeople()
                                                                   .then()
                                                                   .spec(responseSpecificationForOkResponse())
                                                                   .extract()
                                                                   .as(PersonListResponse.class);

        assertThat(responseBody.getMeta().getPagination().getLimit()).isEqualTo(10);
        assertThat(responseBody.getData()).hasSize(10);
    }

    @ParameterizedTest
    @MethodSource("limitQueryParameterDataProvider")
    void getPeopleWithQueryParams(Map<String, String> queryParams) {
        var responseBody = new PeopleClient(requestSpecification()).getPeople(queryParams)
                                                                   .then()
                                                                   .spec(responseSpecificationForOkResponse())
                                                                   .extract()
                                                                   .as(PersonListResponse.class);

        assertThat(responseBody.getMeta().getPagination().getLimit())
            .isEqualTo(Integer.parseInt(queryParams.get("limit")));
        assertThat(responseBody.getData()).hasSize(Integer.parseInt(queryParams.get("limit")));
    }

    @ParameterizedTest
    @MethodSource("createPersonNegativeDataProvider")
    void createPersonNegativeTest(CreatePersonDataRequest requestBody, String missingFieldName) {
        var expectedResponse = ProblemResponse
            .builder()
            .type("validation")
            .title("Bad Request")
            .status("400")
            .detail("A malformed request was sent")
            .violations(List.of(Violation
                .builder()
                .code("missing_field")
                .field(String.join(".", "CreatePersonData", missingFieldName))
                .detail("must not be null")
                .build()))
            .build();

        var responseBody = new PeopleClient(requestSpecification())
            .createPerson(requestBody)
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_BAD_REQUEST)
            .extract()
            .as(ProblemResponse.class);

        assertThat(responseBody).isEqualTo(expectedResponse);
    }

    @ParameterizedTest
    @MethodSource("createPersonNegativeWithInvalidEmailDataProvider")
    void createPersonNegativeWithInvalidEmailTest(CreatePersonDataRequest requestBody, Violation violation) {
        var expectedResponse = ProblemResponse
            .builder()
            .type("validation")
            .title("Bad Request")
            .status("400")
            .detail("A malformed request was sent")
            .violations(List.of(violation))
            .build();

        var responseBody = new PeopleClient(requestSpecification())
            .createPerson(requestBody)
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_BAD_REQUEST)
            .extract()
            .as(ProblemResponse.class);

        assertThat(responseBody).isEqualTo(expectedResponse);
    }
}
