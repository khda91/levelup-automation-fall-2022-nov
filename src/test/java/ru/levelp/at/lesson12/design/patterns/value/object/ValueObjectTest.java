package ru.levelp.at.lesson12.design.patterns.value.object;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;
import org.apache.http.HttpStatus;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.levelp.at.lesson0809.api.model.AddressData;
import ru.levelp.at.lesson0809.api.model.CreatePersonDataRequest;
import ru.levelp.at.lesson0809.api.model.IdentityData;
import ru.levelp.at.lesson0809.api.model.PassportData;
import ru.levelp.at.lesson0809.api.model.ProblemResponse;
import ru.levelp.at.lesson0809.api.model.Violation;
import ru.levelp.at.lesson0809.api.service.PeopleClient;

public class ValueObjectTest {

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

    static Stream<Arguments> valueObjectDataProvider() {
        return Stream.of(
            Arguments.of(CreatePersonDataRequest.builder().build(),
                ProblemResponse.builder().status("400").build()),
            Arguments.of(CreatePersonDataRequest.builder().build(),
                ProblemResponse.builder().status("422").build())
            // ....
        );
    }

    RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(8080)
            .setBasePath("srv-person-profile")
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();
    }

    @ParameterizedTest
    @MethodSource("createPersonNegativeWithInvalidEmailDataProvider")
    void createPersonNegativeTest(CreatePersonDataRequest requestBody, String status, String title,
                                  String detail, String type, Violation violation) {
        var expectedResponse = ProblemResponse
            .builder()
            .type(type)
            .title(title)
            .status(status)
            .detail(detail)
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

    @ParameterizedTest
    @MethodSource("valueObjectDataProvider")
    void createPersonNegativeWithInvalidEmailTest(CreatePersonDataRequest requestBody,
                                                  ProblemResponse expectedResponse) {
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
