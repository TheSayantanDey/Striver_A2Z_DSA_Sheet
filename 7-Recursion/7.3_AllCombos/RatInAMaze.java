package Recursion_Hard;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {
    //Own approach
    /*
    public static void solve(int[][] matrix, int x, int y, StringBuilder path, List<String> allPaths){
        if(x==matrix.length-1 && y==matrix.length-1 && matrix[x][y]==1){
            allPaths.add(path.toString());
            return;
        }
        //Check Bound
        if(x<0 || x==matrix.length || y<0 || y==matrix.length || matrix[x][y]==0) return;

        matrix[x][y] = 0;
        //Go up
        path.append('U');
        solve(matrix,x-1,y,path,allPaths);
        path.deleteCharAt(path.length()-1);

        //Go down
        path.append('D');
        solve(matrix,x+1,y,path,allPaths);
        path.deleteCharAt(path.length()-1);

        //Go Left
        path.append('L');
        solve(matrix,x,y-1,path,allPaths);
        path.deleteCharAt(path.length()-1);

        //Go right
        path.append('R');
        solve(matrix,x,y+1,path,allPaths);
        path.deleteCharAt(path.length()-1);

        matrix[x][y] = 1;
        return;
    }
    public static ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> allPaths = new ArrayList<>();
        solve(mat,0,0,new StringBuilder(),allPaths);
        return allPaths;
    }

     */

    //Shortening the code
    public static void solve(int[][] matrix, int x, int y, int[] di, int[] dj,StringBuilder path, List<String> allPaths){
        if(x==matrix.length-1 && y==matrix.length-1 && matrix[x][y]==1){
            allPaths.add(path.toString());
            return;
        }
        //Check Bound
        if(x<0 || x==matrix.length || y<0 || y==matrix.length || matrix[x][y]==0) return;
        String dir = "ULRD";

        matrix[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int newX = x+di[i];
            int newY = y+dj[i];
            path.append(dir.charAt(i));
            solve(matrix,newX,newY,di,dj,path,allPaths);
            path.deleteCharAt(path.length()-1);
        }
        matrix[x][y] = 1;
        return;
    }
    public static ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> allPaths = new ArrayList<>();
        int[] di = {-1,0,0,1};
        int[] dj = {0,-1,1,0};
        solve(mat,0,0,di,dj,new StringBuilder(),allPaths);
        return allPaths;
    }

    public static void main(String[] args) {
        int[][] matrix ={{1, 0, 0, 0},
                         {1, 1, 0, 1},
                         {1, 1, 0, 0},
                         {0, 1, 1, 1}};
        System.out.println(findPath(matrix));
    }
}
