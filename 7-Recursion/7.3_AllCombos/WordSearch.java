package Recursion_Hard;

import java.util.HashSet;
import java.util.List;

public class WordSearch {

    //Own approach
    /*
    public static boolean findPath(char[][] board, String word,int index,int posX,int posY,int[][] visited){
        if(index==word.length()-1) return true;

        //Check right
        if(posY<board[0].length-1 && visited[posX][posY+1]!=1 && board[posX][posY+1]==word.charAt(index+1)){
            visited[posX][posY+1]=1;
            if(findPath(board,word,index+1,posX,posY+1,visited)) return true;
            visited[posX][posY+1]=0;
        }
        //check left
        if(posY>0 && visited[posX][posY-1]!=1 && board[posX][posY-1]==word.charAt(index+1)){
            visited[posX][posY-1]=1;
            if(findPath(board,word,index+1,posX,posY-1,visited)) return true;
            visited[posX][posY-1]=0;
        }
        //check up
        if(posX>0 && visited[posX-1][posY]!=1 && board[posX-1][posY]==word.charAt(index+1)){
            visited[posX-1][posY]=1;
            if(findPath(board,word,index+1,posX-1,posY,visited)) return true;
            visited[posX-1][posY]=0;
        }
        //check down
        if(posX<board.length-1 && visited[posX+1][posY]!=1 && board[posX+1][posY]==word.charAt(index+1)){
            visited[posX+1][posY]=1;
            if(findPath(board,word,index+1,posX+1,posY,visited)) return true;
            visited[posX+1][posY]=0;
        }

        return false;
    }
    public static boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)){
                    //Call recursion
                    visited[i][j] = 1;
                    if(findPath(board,word,0,i,j,visited))return true;
                    visited[i][j] = 0;
                }
            }
        }
        return false;
    }

     */

    //Optimised approach with better code
    public static boolean findPath(char[][] board, String word,int index,int posX,int posY,int m,int n){
        if(index==word.length()) return true;

        //Check boundaries first
        if(posX<0 || posX==m || posY<0 || posY==n || board[posX][posY]!=word.charAt(index)) return false;

        //Call recursion in all four direction
        //First change the current char so that one character doesn't end up taking twice or more
        char c = board[posX][posY];
        board[posX][posY] = '!';

        //Call up
        boolean up = findPath(board,word,index+1,posX-1,posY,m,n);
        //Call down
        boolean down = findPath(board,word,index+1,posX+1,posY,m,n);
        //Call left
        boolean left = findPath(board,word,index+1,posX,posY-1,m,n);
        //Call right
        boolean right = findPath(board,word,index+1,posX,posY+1,m,n);

        board[posX][posY] = c;

        return up || down || left || right;
    }
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        //First search the first character
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)){
                    //Call recursion
                    if(findPath(board,word,0,i,j,m,n))return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board,word));
    }
}
