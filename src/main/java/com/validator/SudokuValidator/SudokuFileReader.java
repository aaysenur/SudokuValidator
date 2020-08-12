package com.validator.SudokuValidator;

import com.validator.SudokuValidator.domain.Sudoku;
import com.validator.SudokuValidator.exception.InvalidFileException;
import com.validator.SudokuValidator.exception.NonEqualRowAndColumnException;
import com.validator.SudokuValidator.util.MathOperator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SudokuFileReader {

    static class Board {
        int[][] problem;
        List<String> rowList;

        public Board(List<String> rowList) {
            this.rowList = rowList;
        }
    }

    private final String FILE_SEPARATOR = ",";

    public Sudoku readFile(String file) {
        String line = "";
        List<String> rowList = new ArrayList<>();
        int subsquareSize = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            //Read file line by line
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                if ("".equals(line)) {
                    throw new InvalidFileException("Specified file cannot contain invalid lines: " + file);
                }
                rowList.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new InvalidFileException("Specified file cannot be found: " + file);
        } catch (IOException e) {
            throw new InvalidFileException("Unexpected IO Exception during reading file: " + file);
        }

        Board board = new Board(rowList);
        processRows(board);

        int dimension = board.rowList.size();
        subsquareSize = MathOperator.findSquarreRootOfNumber(dimension);

        Sudoku sudoku = new Sudoku(dimension, board.problem, subsquareSize);
        return sudoku;

    }

    public void processRows(Board board) {
        int rowNumber = board.rowList.size();

        for (int i = 0; i < rowNumber; i++) {
            String row = board.rowList.get(i);
            String[] colList = row.split(FILE_SEPARATOR);
            int colNumber = colList.length;

            //Check given input square or not
            if (rowNumber != colNumber) {
                throw new NonEqualRowAndColumnException("Board is invalid: Row Number and Column Number should be equal.");
            }

            //Initialize the board
            if (i == 0) {
                board.problem = new int[rowNumber][colNumber];
            }

            //fill the array
            for (int j = 0; j < colNumber; j++) {
                board.problem[i][j] = Integer.parseInt(colList[j]);
            }
        }
    }
}
