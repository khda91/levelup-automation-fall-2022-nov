package ru.levelp.at.taf.exception;

public class BoardNotFoundException extends IllegalArgumentException {

    public BoardNotFoundException(String boardName) {
        super(String.format("Board with name %s was not found.", boardName));
    }
}
