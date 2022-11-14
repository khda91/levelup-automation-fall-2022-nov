package ru.levelp.at.lesson0304.unit;

import java.util.List;
import java.util.stream.Collectors;

public class ListManipulator {

    public List<String> manipulate(List<String> list, String letter) {
        if (list == null) {
            throw new IllegalArgumentException("Список не может быть null.");
        }

        if (letter == null) {
            throw new IllegalArgumentException("Буква не может быть null.");
        }

        return list.stream()
            .map(item -> item.replaceAll(letter + "|" + letter.toUpperCase(), ""))
            .collect(Collectors.toList());
    }
}
