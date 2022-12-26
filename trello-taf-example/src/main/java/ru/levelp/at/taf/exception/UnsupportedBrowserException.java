package ru.levelp.at.taf.exception;

public class UnsupportedBrowserException extends IllegalArgumentException {

    public UnsupportedBrowserException(String browserName) {
        super(String.format("Browser %s is unsupported!", browserName));
    }
}
