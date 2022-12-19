package ru.levelp.at.lesson1011.allure.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
public class CreatePersonDataRequest {

    private String role;
    private String email;
    private String phoneNumber;
    private String placeOfWork;

    @JsonProperty("identity")
    private IdentityData identityData;

    @JsonProperty("address")
    private AddressData addressData;
}
