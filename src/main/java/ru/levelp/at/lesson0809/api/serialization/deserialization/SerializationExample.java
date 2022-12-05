package ru.levelp.at.lesson0809.api.serialization.deserialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import ru.levelp.at.lesson0809.api.serialization.deserialization.model.Person;

public class SerializationExample {

    public static void main(String[] args) {
        Person vasya = new Person("Василий", "Васильев", LocalDate.now()
                                                                  .minusMonths(5)
                                                                  .minusYears(20),
            true);
        System.out.println(vasya);

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("ser/file.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(vasya);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
