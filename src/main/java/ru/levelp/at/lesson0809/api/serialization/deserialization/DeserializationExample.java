package ru.levelp.at.lesson0809.api.serialization.deserialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import ru.levelp.at.lesson0809.api.serialization.deserialization.model.Person;

public class DeserializationExample {

    public static void main(String[] args) {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ser/file.txt"))) {
            Person vasya = (Person) ois.readObject();
            System.out.println(vasya);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
