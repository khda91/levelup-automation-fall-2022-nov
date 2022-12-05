package ru.levelp.at.lesson0809.api.model;

import java.util.List;
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
public class ProblemResponse {

    private String type;
    private String title;
    private String status;
    private String detail;
    private List<Violation> violations;
}
