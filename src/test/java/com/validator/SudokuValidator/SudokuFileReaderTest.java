package com.validator.SudokuValidator;

import com.validator.SudokuValidator.domain.Sudoku;
import com.validator.SudokuValidator.exception.InvalidFileException;
import com.validator.SudokuValidator.exception.NonEqualRowAndColumnException;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SudokuFileReaderTest {

    @Test
    public void readNotFoundFile() {
        SudokuFileReader sudokuFileReader = new SudokuFileReader();

        assertThrows(InvalidFileException.class, () -> sudokuFileReader.readFile("notFound.txt"));
    }

    @Test
    public void processRowsWithNonEqualRowAndColumnExceptions() {
        SudokuFileReader sudokuFileReader = new SudokuFileReader();
        String line = "";
        List<String> rowList = new ArrayList<>();

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("nonEqualRowAndColumn.txt").getFile());

        try (InputStream inputStream = new FileInputStream(file)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            //Read file line by line
            while ((line = reader.readLine()) != null) {
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

        SudokuFileReader.Board board = new SudokuFileReader.Board(rowList);

        assertThrows(NonEqualRowAndColumnException.class, () -> sudokuFileReader.processRows(board));

    }
}
