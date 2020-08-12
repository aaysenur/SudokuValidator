package com.validator.SudokuValidator.util;

public class MathOperator {

    public static int findSquarreRootOfNumber(int n) {
        double sqroot = Math.sqrt(n);
        if (sqroot - Math.floor(sqroot) == 0) {
            return (int) sqroot;
        }
        return -1;
    }
}
