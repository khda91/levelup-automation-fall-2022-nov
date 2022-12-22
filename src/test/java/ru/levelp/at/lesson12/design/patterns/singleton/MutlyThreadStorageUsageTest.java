package ru.levelp.at.lesson12.design.patterns.singleton;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

class MutlyThreadStorageUsageTest {

    private static final Faker FAKER = new Faker();

    @Test
    void test1() {
        System.out.println("test1");

        var runnable = new Runnable() {
            @Override
            public void run() {
                // Storage.getInstance().put(FAKER.name().firstName(), FAKER.name().lastName());
                //                Storage.getInstance().put(FAKER.name().firstName(), FAKER.name().lastName());
                //                System.out.println("========");
                System.out.println("Thread: " + Thread.currentThread().getName() + " data -> "
                    + Storage.getInstance().getAll());
            }
        };

        var thread1 = new Thread(runnable);
        var thread2 = new Thread(runnable);
        var thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();
    }

    @Test
    void test2() {
        System.out.println("test1");

        var runnable = new Runnable() {
            @Override
            public void run() {
                // Storage.getInstance().put(FAKER.name().firstName(), FAKER.name().lastName());
                //                Storage.getInstance().put(FAKER.name().firstName(), FAKER.name().lastName());
                //                System.out.println("========");
                System.out.println("Thread: " + Thread.currentThread().getName() + " data -> "
                    + StorageMultiThreading.getInstance().getAll());
            }
        };

        var thread1 = new Thread(runnable);
        var thread2 = new Thread(runnable);
        var thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
