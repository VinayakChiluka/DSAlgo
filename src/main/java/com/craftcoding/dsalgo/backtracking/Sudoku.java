package com.craftcoding.dsalgo.backtracking;

public class Sudoku {

    private void print(int[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void solve(int[][] board,int n, int row,int col){
        if(row == n){
            print(board);
            System.out.println();
            return;
        }

        int nRow=0, nCol=0;

        if(col == n-1){
            nCol = 0;
            nRow = row + 1;
        }
        else{
            nRow = row;
            nCol = col + 1;
        }
        if(board[row][col] != 0){
            solve(board,n,nRow,nCol);
        }
        else
            for(int pos=1;pos<=9;pos++){
                if(isValid(board, row, col, pos)){
                    board[row][col] = pos;
                    solve(board, n, nRow, nCol);
                    board[row][col] = 0;
                }
            }
    }

    boolean isValid(int[][] board, int row, int col, int pos){
        // column check
        for (int i=0;i<9;i++){
            if(board[row][i] == pos){
                return false;
            }
        }

        // row check
        for (int i=0;i<9;i++){
            if(board[i][col] == pos){
                return false;
            }
        }

        //sub matrix row index
        int sri = (row/3) * 3;
        // sub matrix col index
        int sci = (col/3) * 3;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[sri+i][sci+j] == pos)
                    return false;
            }
        }


        return true;
    }

}
