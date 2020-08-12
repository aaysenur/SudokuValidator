package com.validator.SudokuValidator.domain;

public class Sudoku {

    private int rowNumbers;
    private int columnNumbers;
    private int[][] board;
    private int subsquareSize;

    public Sudoku(int dimension, int[][] board, int subsquareSize) {
        this.rowNumbers = dimension;
        this.columnNumbers = dimension;
        this.board = board;
        this.subsquareSize = subsquareSize;
    }

    public int getRowNumbers() {
        return rowNumbers;
    }

    public void setRowNumbers(int rowNumbers) {
        this.rowNumbers = rowNumbers;
    }

    public int getColumnNumbers() {
        return columnNumbers;
    }

    public void setColumnNumbers(int columnNumbers) {
        this.columnNumbers = columnNumbers;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int getSubsquareSize() {
        return subsquareSize;
    }

    public void setSubsquareSize(int subsquareSize) {
        this.subsquareSize = subsquareSize;
    }
}
