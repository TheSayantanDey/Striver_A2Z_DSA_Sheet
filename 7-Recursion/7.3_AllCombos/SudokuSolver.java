package Recursion_Hard;

import java.util.ArrayList;
import java.util.Arrays;

public class SudokuSolver {
    
    //This isSafe function can be optimised into a single loop
    /*
    public static boolean isSafe(char[][] board,int i, int j, char c){
        for (int k = 0; k < 9; k++) if(board[i][k]==c) return false;
        for (int k = 0; k < 9; k++) if(board[k][j]==c) return false;

        int a = i-(i%3);
        int b = j-(j%3);
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if(board[a+k][b+l] == c) return false;
            }
        }
        return true;
    }
    
     */
    //Optimised isSafe() (Although it takes more time in leetcode)
    public static boolean isSafe(char[][] board,int i, int j, char c){
        for (int k = 0; k < 9; k++) {
            if(board[i][k]==c) return false; //Checks row wise
            if(board[k][j]==c) return false; //Checks column wise

            if(board[3*(i/3) + k/3][3*(j/3) + k%3] == c) return false; //Checks the sub-grid
        }
        return true;
    }
    
    public static boolean solve(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.'){
                    for (char c = '1'; c <= '9'; c++) {
                        if(isSafe(board,i,j,c)){
                            board[i][j] = c;
                            if(solve(board)){
                                return true;
                            }else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    public static void main(String[] args) {
        char[][] board={{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println("----------------------------------------");
        solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
