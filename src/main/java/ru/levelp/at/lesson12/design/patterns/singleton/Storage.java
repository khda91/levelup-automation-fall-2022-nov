package ru.levelp.at.lesson12.design.patterns.singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class Storage {

    private static Storage instance;

    private final Map<String, String> storage;

    private Storage() {
        this.storage = new HashMap<>();
    }

    public static Storage getInstance() {
        if (instance == null) {
            System.out.println("create new storage");
            instance = new Storage();
        }
        return instance;
    }

    public void put(String key, String value) {
        storage.put(key, value);
    }

    public String get(String key) {
        return storage.get(key);
    }

    public Set<Entry<String, String>> getAll() {
        return storage.entrySet();
    }
}
