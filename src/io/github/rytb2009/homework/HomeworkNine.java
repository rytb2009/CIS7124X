package io.github.rytb2009.homework;

public class HomeworkNine {

    public static void main(String[] args) {
        int[][] board = {{3,0,6,5,0,8,4,0,0},
                         {5,2,0,0,0,0,0,0,0},
                         {0,8,7,0,0,0,0,3,1},
                         {0,0,3,0,1,0,0,8,0},
                         {9,0,0,8,6,3,0,0,0},
                         {0,0,0,0,9,0,6,0,0},
                         {0,3,0,0,0,0,2,5,0},
                         {0,0,0,0,0,0,0,7,0},
                         {0,0,5,2,0,6,3,0,0}};
        System.out.println(solveSudoku(board));
        for (int[] row:board) {
            for (int i: row) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    private static boolean solveSudoku(int[][] board) {
        return solveSudoku(board, 0);
    }

    private static boolean solveSudoku(int[][] board, int row) {
        for (int i = row; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {   // if empty cell, try filling cell
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;
                            if (solveSudoku(board, i)) { // if solved return
                                return true;
                            }
                            board[i][j] = 0;  // else backtrack
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int[][] board, int r, int c, int val) {
        int rowOffset = (r/3)*3;
        int colOffset = (c/3)*3;
        for (int i = 0; i < 9; i++) {
            if (i != c && board[r][i] == val) return false;   // check that row
            if (i != r && board[i][c] == val) return false;   // check that col
            int row = i/3 + rowOffset;  // check that block
            int col = i%3 + colOffset;
            if (row != r && col != c && board[row][col] == val) return false;
        }
        return true;
    }
}
