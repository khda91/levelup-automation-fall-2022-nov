package ru.levelp.at;

import java.io.IOException;

public class SomeClass {

    public static void someMethod(Object o) {
        var request = o.getClass().getClassLoader().getResource("");

        if (request.getFile() != null) {
            // сделай то-то
        } else if (request ==  null) {
            // идём по другой ветке
        }

        try {
            //
        } catch (Exception e) {
            //
        }
    }
}
