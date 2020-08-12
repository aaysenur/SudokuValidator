package com.validator.SudokuValidator;

import com.validator.SudokuValidator.util.MathOperator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidatonOperatorsTest {

    /**
     * Board should contain invalid numbers and return -1 for the first row
     */
    @Test
    public void testRowValidation_withInvalidNumbers() {
        int[][] board = {
                {1, 5, 2, 3},
                {2, 3, 1, 4},
                {4, 2, 3, 1},
                {3, 1, 4, 2},
        };

        int arrayLength = board.length;
        int actualValue = 0;

        List<Integer> validationResults = new ArrayList<>();

        for (int i = 0; i < arrayLength; i++) {
            actualValue = ValidationOperators.checkRowValid(i, board, arrayLength);
            validationResults.add(actualValue);
        }

        List<Integer> expectedValidation = Arrays.asList(-1, 1, 1, 1);
        assertEquals(expectedValidation, validationResults);
    }

    /**
     * Board should contain repeated numbers and return 0 for that row
     */
    @Test
    public void testRowValidation_withRepeatedNumbersInOneRow() {
        int[][] board = {
                {1, 2, 2, 3},
                {2, 3, 1, 4},
                {4, 2, 3, 1},
                {3, 1, 4, 2},
        };

        int arrayLength = board.length;
        int actualValue = 0;

        List<Integer> validationResults = new ArrayList<>();

        for (int i = 0; i < arrayLength; i++) {
            actualValue = ValidationOperators.checkRowValid(i, board, arrayLength);
            validationResults.add(actualValue);
        }

        List<Integer> expectedValidation = Arrays.asList(0, 1, 1, 1);
        assertEquals(expectedValidation, validationResults);
    }

    /**
     * Board should contain valid numbers and return 1 for all rows
     */
    @Test
    public void testRowValidation_withValidNumbers() {
        int[][] board = {
                {1, 4, 2, 3},
                {2, 3, 1, 4},
                {4, 2, 3, 1},
                {3, 1, 4, 2},
        };

        int arrayLength = board.length;
        int actualValue = 0;

        List<Integer> validationResults = new ArrayList<>();

        for (int i = 0; i < arrayLength; i++) {
            actualValue = ValidationOperators.checkRowValid(i, board, arrayLength);
            validationResults.add(actualValue);
        }

        List<Integer> expectedValidation = Arrays.asList(1, 1, 1, 1);
        assertEquals(expectedValidation, validationResults);
    }

    /**
     * Board should contain invalid numbers and return -1 for the second column
     */
    @Test
    public void testColumnValidation_withInvalidNumbers() {
        int[][] board = {
                {1, 4, 2, 3},
                {2, -2, 1, 4},
                {4, 2, 3, 1},
                {3, 1, 4, 2},
        };

        int arrayLength = board.length;
        int actualValue = 0;

        List<Integer> validationResults = new ArrayList<>();

        for (int i = 0; i < arrayLength; i++) {
            actualValue = ValidationOperators.checkColumnValid(i, board, arrayLength);
            validationResults.add(actualValue);
        }

        List<Integer> expectedValidation = Arrays.asList(1, -1, 1, 1);
        assertEquals(expectedValidation, validationResults);
    }

    /**
     * Board should contain repeated numbers and return 0 for the first column
     */
    @Test
    public void testColumnValidation_withRepeatedNumbersInOneColumn() {
        int[][] board = {
                {1, 4, 2, 3},
                {1, 3, 1, 4},
                {4, 2, 3, 1},
                {3, 1, 4, 2},
        };

        int arrayLength = board.length;
        int actualValue = 0;

        List<Integer> validationResults = new ArrayList<>();

        for (int i = 0; i < arrayLength; i++) {
            actualValue = ValidationOperators.checkColumnValid(i, board, arrayLength);
            validationResults.add(actualValue);
        }

        List<Integer> expectedValidation = Arrays.asList(0, 1, 1, 1);
        assertEquals(expectedValidation, validationResults);
    }

    /**
     * Board should contain valid numbers and return 1 for all columns
     */
    @Test
    public void testColumnValidation_withValidNumbers() {
        int[][] board = {
                {1, 4, 2, 3},
                {2, 3, 1, 4},
                {4, 2, 3, 1},
                {3, 1, 4, 2},
        };

        int arrayLength = board.length;
        int actualValue = 0;

        List<Integer> validationResults = new ArrayList<>();

        for (int i = 0; i < arrayLength; i++) {
            actualValue = ValidationOperators.checkColumnValid(i, board, arrayLength);
            validationResults.add(actualValue);
        }

        List<Integer> expectedValidation = Arrays.asList(1, 1, 1, 1);
        assertEquals(expectedValidation, validationResults);
    }

    /**
     * Board should contain invalid numbers for at least one subsquare and return -1
     */
    @Test
    public void testSubSquareValidation_withInvalidNumbers() {
        int[][] board = {
                {1, 5, 2, 3},
                {2, 3, 1, 4},
                {4, 2, 3, 1},
                {3, 1, 4, 2},
        };

        int arrayLength = board.length;
        int actualValue = 0;

        //It is for computing subsquare length
        int subsquareSize = MathOperator.findSquarreRootOfNumber(arrayLength);

        actualValue = ValidationOperators.checkSubSquaresValid(board, arrayLength, arrayLength, subsquareSize);

        assertEquals(-1, actualValue);
    }

    /**
     * Board should contain repeated numbers for at least one subsquare and return 0
     */
    @Test
    public void testSubSquareValidation_withRepeatedNumbers() {
        int[][] board = {
                {1, 3, 2, 3},
                {2, 3, 1, 4},
                {4, 2, 3, 1},
                {3, 1, 4, 2},
        };

        int arrayLength = board.length;
        int actualValue = 0;

        //It is for computing subsquare length
        int subsquareSize = MathOperator.findSquarreRootOfNumber(arrayLength);

        actualValue = ValidationOperators.checkSubSquaresValid(board, arrayLength, arrayLength, subsquareSize);

        assertEquals(0, actualValue);
    }

    /**
     * Board should contain repeated numbers for at least one subsquare and return 0
     */
    @Test
    public void testSubSquareValidation_withValidNumbers() {
        int[][] board = {
                {1, 4, 2, 3},
                {2, 3, 1, 4},
                {4, 2, 3, 1},
                {3, 1, 4, 2},
        };

        int arrayLength = board.length;
        int actualValue = 0;

        //It is for computing subsquare length
        int subsquareSize = MathOperator.findSquarreRootOfNumber(arrayLength);

        actualValue = ValidationOperators.checkSubSquaresValid(board, arrayLength, arrayLength, subsquareSize);

        assertEquals(1, actualValue);
    }

}
