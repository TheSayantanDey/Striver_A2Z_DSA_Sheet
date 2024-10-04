package Recursion_Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {
    //Own method
/*
    public static String generateRow(int n,int queenPos){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(i==queenPos) s.append('Q');
            else s.append('.');
        }
        return s.toString();
    }
    public static boolean checkDiagonals(int n,List<String> prevAns,int column){
        int row = prevAns.size();
        for (int i = 0; i < prevAns.size(); i++) {
            if(column-row+i>=0 && prevAns.get(i).charAt(column-row+i)=='Q') return false;
            else if(column+row-i<n && prevAns.get(i).charAt(column+row-i)=='Q') return false;
        }
        return true;
    }
    public static void findSol(int n,int[] colTaken,List<String> prevAns,List<List<String>> solutions){

        for (int i = 0; i < n; i++) {
            if(colTaken[i]!=1 && checkDiagonals(n,prevAns,i)){

                colTaken[i] = 1;
                prevAns.add(generateRow(n,i));
                if(prevAns.size()==n){ //Base case
                    solutions.add(new ArrayList<>(prevAns));
                }else{
                    findSol(n,colTaken,prevAns,solutions);
                }
                prevAns.remove(prevAns.size()-1);
                colTaken[i] =0;
            }
        }
        return;
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] colTaken = new int[n];
        findSol(n,colTaken,new ArrayList<>(),solutions);
        return solutions;
    }
*/
/*
    //Brute
    public static String generateRow(int n,int queenPos){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(i==queenPos) s.append('Q');
            else s.append('.');
        }
        return s.toString();
    }
    public static boolean isSafe(int n,List<String> board,int column){
        int row=board.size();
        //Check for left diagonal
        int i=row-1,j=column-1;
        while (i>=0 && j>=0){
            if(board.get(i).charAt(j)=='Q') return false;
            i--;
            j--;
        }
        //Check for right diagonal
        i=row-1;
        j=column+1;
        while (i>=0 && j<n){
            if(board.get(i).charAt(j)=='Q') return false;
            i--;
            j++;
        }
        //Check for colWise
        i=row-1;
        j=column;
        while(i>=0){
            if(board.get(i).charAt(j) == 'Q') return false;
            i--;
        }

        return true;
    }
    public static void solve(int n,List<String> prevAns,List<List<String>> solutions){

        for (int i = 0; i < n; i++) {
            if(isSafe(n,prevAns,i)){
                prevAns.add(generateRow(n,i));
                if(prevAns.size()==n){ //Base case
                    solutions.add(new ArrayList<>(prevAns));
                }else{
                    solve(n,prevAns,solutions);
                }
                prevAns.remove(prevAns.size()-1);
            }
        }
        return;
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        solve(n,new ArrayList<>(),solutions);
        return solutions;
    }
 */

    //Optimising the time for finding the previous queen or rather optimising the isSafe() function
    /*
    public static String generateRow(int n,int queenPos){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(i==queenPos) s.append('Q');
            else s.append('.');
        }
        return s.toString();
    }
    public static boolean isSafe(int n,int row,int column,int[] columnTaken,int[] leftDiagonalTaken,int[] rightDiagonalTaken){
        if(columnTaken[column] == 1) return false;
        if(leftDiagonalTaken[(n-1)+(column-row)]==1)return false;
        if(rightDiagonalTaken[row+column]==1) return false;

        return true;
    }
    public static void solve(int n,List<String> board,int[] columnTaken, int[] leftDiagonalTaken, int[] rightDiagonalTaken, List<List<String>> solutions){
        int row = board.size(); // We are working for row'th row
        for (int i = 0; i < n; i++) {
            if(isSafe(n,row,i,columnTaken,leftDiagonalTaken,rightDiagonalTaken)){

                board.add(generateRow(n,i));
                columnTaken[i] = 1;
                leftDiagonalTaken[(n-1)+(i-row)] = 1;
                rightDiagonalTaken[i+row] = 1;

                if(board.size()==n){ //Base case
                    solutions.add(new ArrayList<>(board));
                }else{
                    solve(n,board,columnTaken,leftDiagonalTaken,rightDiagonalTaken,solutions);
                }

                columnTaken[i] = 0;
                leftDiagonalTaken[(n-1)+(i-row)] = 0;
                rightDiagonalTaken[i+row] = 0;
                board.remove(board.size()-1);
            }
        }
        return;
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] columnTaken = new int[n];
        int[] leftDiagonalTaken = new int[(2*n)-1];
        int[] rightDiagonalTaken = new int[(2*n)-1];
        solve(n,new ArrayList<>(),columnTaken,leftDiagonalTaken,rightDiagonalTaken,solutions);
        return solutions;
    }
    */

    //Better code
    public static List<String> convert(char[][] board){
        List<String> result = new ArrayList<>();
        for (char[] rows : board) {
            String s = new String(rows);
            result.add(s);
        }
        return result;
    }
    public static void solve(int row,char[][] board,int[] column, int[] leftDiagonal, int[] rightDiagonal, List<List<String>> solutions){
        //Base case
        if(row==board.length){
            //Convert the board into a result
            solutions.add(convert(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if(column[i]==0 && leftDiagonal[(board.length-1)+(i-row)] == 0 && rightDiagonal[i+row]==0){

                board[row][i] = 'Q';
                column[i] = 1;
                leftDiagonal[(board.length-1)+(i-row)] = 1;
                rightDiagonal[i+row] = 1;

                solve(row+1,board,column,leftDiagonal,rightDiagonal,solutions);

                board[row][i] = '.';
                column[i] = 0;
                leftDiagonal[(board.length-1)+(i-row)] = 0;
                rightDiagonal[i+row] = 0;
            }
        }
        return;
    }
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i=0;i<n;i++){
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> solutions = new ArrayList<>();
        int[] column = new int[n];
        int[] leftDiagonal = new int[(2*n)-1];
        int[] rightDiagonal = new int[(2*n)-1];
        solve(0,board,column,leftDiagonal,rightDiagonal,solutions);
        return solutions;
    }

    public static void print(List<List<String>> solutions){
        for (List<String> res : solutions) {
            for (String re : res) {
                for (int k = 0; k < re.length(); k++) {
                    System.out.print("  " + re.charAt(k) + "  ");
                }
                System.out.println();
            }
            System.out.println("------------------------------------------------------------------");
        }
    }
    public static void main(String[] args) {
        List<List<String>> solutions = solveNQueens(8);
        System.out.println("Total combination found: "+solutions.size());
        print(solutions);
    }
}
