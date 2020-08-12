package com.validator.SudokuValidator;

import com.validator.SudokuValidator.domain.Sudoku;
import com.validator.SudokuValidator.exception.InvalidFileException;
import com.validator.SudokuValidator.exception.NonEqualRowAndColumnException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.validator.SudokuValidator.ValidationOperators.validateBoard;

@SpringBootApplication
public class SudokuValidatorApplication {

    private static Logger LOG = LoggerFactory.getLogger(SudokuValidatorApplication.class);

    public static void main(String[] args) {

        //File is sent by command prompt
        System.out.println("The file to be validated: " + args[0]);
        String file = args[0];

        try {
            SudokuFileReader sudokuFileReader = new SudokuFileReader();
            Sudoku sudoku = sudokuFileReader.readFile(file);
            validateBoard(sudoku.getBoard(), sudoku.getRowNumbers(), sudoku.getColumnNumbers(), sudoku.getSubsquareSize());
        } catch (InvalidFileException e) {
            LOG.error("The board is 'INVALID'");
        } catch (NonEqualRowAndColumnException e) {
            LOG.error("Board is invalid: Row Number and Column Number should be equal.");
        }
    }

}
