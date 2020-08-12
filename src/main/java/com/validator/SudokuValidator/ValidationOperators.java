package com.validator.SudokuValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class ValidationOperators {

    private static Logger LOG = LoggerFactory.getLogger(ValidationOperators.class);

    /**
     * It checks if the given row is valid or not valid
     * It will return 1 if the row is valid
     * It will return 0 if the row contains repeated numbers
     * It will return -1 if the row is invalid
     *
     * @param row
     * @param board
     * @param rowNumber
     * @return
     */
    public static int checkRowValid(int row, int[][] board, int rowNumber) {
        int selectedRow[] = board[row];
        Set<Integer> rowSet = new HashSet<>();

        for (int i : selectedRow) {

            //Check if the row contains invalid numbers
            if (i < 0 || i > rowNumber) {
                LOG.warn("Row contains invalid numbers: " + i);
                return -1;
            }

            //Check if the row contains repeated numbers
            else if (i != 0) {
                if (rowSet.add(i) == false) {
                    LOG.warn("Row: " + i + " contains repeated numbers");
                    return 0;
                }
            }
        }
        return 1;
    }

    /**
     * It checks if the given column is valid or not valid
     * It will return 1 if the column is valid
     * It will return 0 if the column contains repeated numbers
     * It will return -1 if the column is invalid
     *
     * @param column
     * @param board
     * @param rowNumber
     * @return
     */
    public static int checkColumnValid(int column, int[][] board, int rowNumber) {
        Set<Integer> columnSet = new HashSet<>();

        for (int i = 0; i < rowNumber; i++) {


            //Check if the column contains invalid numbers
            if (board[i][column] < 0 || board[i][column] > rowNumber) {
                LOG.warn("Column: " + i + " contains invalid numbers");
                return -1;
            }

            //Check if the column contains repeated numbers
            else if (columnSet.add(board[i][column]) == false) {
                LOG.warn("Column: " + i + " contains repeated numbers");
                return 0;
            }
        }
        return 1;
    }

    /**
     * It checks if the given sunsquares is valid or not valid
     * It will return 1 if the sunsquare is valid
     * It will return 0 if the sunsquare contains repeated numbers
     * It will return -1 if the sunsquare is invalid
     *
     * @param board
     * @param rowNumber
     * @param columnNumber
     * @param subsquareSize
     * @return
     */
    public static int checkSubSquaresValid(int[][] board, int rowNumber, int columnNumber, int subsquareSize) {
        for (int i = 0; i < rowNumber; i = i + subsquareSize) {
            for (int j = 0; j < columnNumber; j = j + subsquareSize) {
                Set<Integer> set = new HashSet<>();

                for (int r = i; r < i + subsquareSize; r++) {
                    for (int c = j; c < j + subsquareSize; c++) {

                        //Check if the square contains invalid numbers
                        if (board[r][c] < 0 || board[r][c] > rowNumber) {
                            LOG.warn("Subsquare in row: " + r + " and in column: " + c + " contains invalid numbers");
                            return -1;
                        }

                        //Check if square contains repeated values
                        else if (board[r][c] != 0) {
                            if (set.add(board[r][c]) == false) {
                                LOG.warn("Subsquare in row: " + r + " and in column: " + c + " contains repeated numbers");
                                return 0;
                            }
                        }

                    }
                }
            }
        }
        return 1;
    }

    /**
     * It will check whether given board is valid or not
     *
     * @param board
     * @param rowNumber
     * @param columnNumber
     * @param subsquareSize
     */
    public static void validateBoard(int[][] board, int rowNumber, int columnNumber, int subsquareSize) {
        for (int i = 0; i < rowNumber; i++) {
            int isRowValid = checkRowValid(i, board, rowNumber);
            int isColumnValid = checkColumnValid(i, board, rowNumber);

            //If row and column are invalid they will return -1 or 0
            if (isRowValid < 1 || isColumnValid < 1) {
                LOG.warn("The board is 'INVALID'");
                return;
            }
        }

        int isValidSubsquares = checkSubSquaresValid(board, rowNumber, columnNumber, subsquareSize);

        //If square is invalid it will return -1 or 0
        if (isValidSubsquares < 1) {
            LOG.warn("The board is 'INVALID'");
            return;
        } else {
            LOG.info("The board is 'VALID'");
        }
    }
}
