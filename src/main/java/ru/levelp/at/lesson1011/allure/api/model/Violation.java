package ru.levelp.at.lesson1011.allure.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
@EqualsAndHashCode
public class Violation {

    private String code;
    private String detail;
    private String field;
}
