package com.validator.SudokuValidator.exception;

public class InvalidFileException extends RuntimeException {
    public InvalidFileException(String message) {
        super(message);
        System.out.println(message);
    }
}
