package com.validator.SudokuValidator.exception;

public class NonEqualRowAndColumnException extends RuntimeException {
    public NonEqualRowAndColumnException(String message) {
        super(message);
        System.out.println(message);
    }
}
