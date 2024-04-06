package com.craftcoding.dsalgo.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SudokuTest {
    private Sudoku sudoku;

    @BeforeEach
    public void prepare(){
        this.sudoku = new Sudoku();
    }

    @Test
    public void validateSudoku(){
        int[][] board =
                {       {7, 0, 0, 0, 0, 0, 2, 0, 0},
                        {4, 0, 2, 0, 0, 0, 0, 0, 3},
                        {0, 0, 0, 2, 0, 1, 0, 0, 0},
                        {3, 0, 0, 1, 8, 0, 0, 9, 7},
                        {0, 0, 9, 0, 7, 0, 6, 0, 0},
                        {6, 5, 0, 0, 3, 2, 0, 0, 1},
                        {0, 0, 0, 4, 0, 9, 0, 0, 0},
                        {5, 0, 0, 0, 0, 0, 1, 0, 6},
                        {0, 0, 6, 0, 0, 0, 0, 0, 8}
                };
                this.sudoku.solve(board, 9,0,0);
    }
}
