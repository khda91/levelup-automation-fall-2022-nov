package ru.levelp.at.utils;

import java.util.concurrent.TimeUnit;

public final class SleepUtils {

    private SleepUtils() {
    }

    public static void sleep(long timeout) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
