package ru.levelp.at;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Params {

    static Stream<Arguments> data() {
        List<Arguments> sssss = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sssss.add(Arguments.of(new Faker().name().fullName()));
        }

        return sssss.stream();
        // return generate(10).stream();
    }

    static List<Arguments> generate(int a) {
        List<Arguments> sssss = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            sssss.add(Arguments.of(new Faker().address().city(), new Faker().address().firstName()));
        }
        return sssss;
    }

    static Stream<Arguments> data1() {
        return generate(10).stream();
    }

    @ParameterizedTest
    @MethodSource({"data", "data1"})
    //    @MethodSource("data")
    void test(String a, String b) {
        //    void test(String a) {
        System.out.println("a -> " + a);
        System.out.println("b -> " + b);
    }
}
