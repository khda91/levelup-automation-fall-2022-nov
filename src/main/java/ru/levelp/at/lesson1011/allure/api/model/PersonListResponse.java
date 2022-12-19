package ru.levelp.at.lesson1011.allure.api.model;

import java.util.List;
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
public class PersonListResponse {

    private List<PersonData> data;
    private MetaData meta;

}
