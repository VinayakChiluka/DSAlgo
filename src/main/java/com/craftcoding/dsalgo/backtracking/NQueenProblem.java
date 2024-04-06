package com.craftcoding.dsalgo.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

    public static void main(String[] args) {
        NQueenProblem nQueenProblem = new NQueenProblem();
        nQueenProblem.solve(4);
    }

    private List<boolean[][]> solve(int n){
        boolean[][] board = new boolean[n][n];
        boolean[] nDia = new boolean[(2*n)+1];
        boolean[] rDia = new boolean[(2*n)+1];
        boolean[] col = new boolean[n];
        List<boolean[][]> results = new ArrayList<>();
        solve(board,col,nDia,rDia,n,0,results);
        return results;
    }

    public int possibleNQueenConfiguration(int n){
        return solve(n).size();
    }


    private void print(boolean[][] board){

        for (boolean[] booleans : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (booleans[j])
                    System.out.print("# ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private void solve(boolean[][] board,boolean[] col,boolean[] nDia,boolean[] rDia, int n, int r, List<boolean[][]> results) {
        if(r >= n){
            results.add(copyBoard(board));
            return;
        }

        for(int c=0;c<n;c++){
            if(isValid(r,c,n, col,nDia,rDia)){
                board[r][c] = true;
                col[c] = true;
                nDia[c+r] = true;
                rDia[c-r+n-1] = true;
                solve(board, col, nDia, rDia, n, r+1, results);
                board[r][c] = false;
                col[c] = false;
                nDia[c+r] = false;
                rDia[c-r+n-1] = false;

            }
        }
    }

    private boolean[][] copyBoard(boolean[][] board) {
        int n = board.length;
        boolean[][] copyBoard = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                copyBoard[i][j] = board[i][j];
            }
        }
        return copyBoard;
    }

    private boolean isValid(int row, int col, int n,  boolean[] columnArray, boolean[] nDia, boolean[] rDia){

        int nDiaIndex = (col + row);
        int rDiaIndex = (col - row + n - 1);

        return !columnArray[col] && !nDia[nDiaIndex] && !rDia[rDiaIndex];

    }

}
