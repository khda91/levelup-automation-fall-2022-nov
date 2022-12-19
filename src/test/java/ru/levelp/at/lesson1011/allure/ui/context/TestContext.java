package ru.levelp.at.lesson1011.allure.ui.context;

import java.util.HashMap;
import java.util.Map;

public final class TestContext {

    private static TestContext instance;

    private final Map<String, Object> context;

    private TestContext() {
        this.context = new HashMap<>();
    }

    public void putObject(String key, Object o) {
        context.put(key, o);
    }

    public Object getObject(String key) {
        return context.get(key);
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }

        return instance;
    }

    public static void clear() {
        instance = null;
    }
}
