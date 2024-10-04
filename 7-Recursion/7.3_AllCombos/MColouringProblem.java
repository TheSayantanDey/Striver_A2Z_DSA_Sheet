package Recursion_Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MColouringProblem {
    public static boolean isSafe(ArrayList<Integer>[] graph,int curr,int[] colors,int currColor){
        for (int i = 0; i < graph[curr].size(); i++) {
            if(colors[graph[curr].get(i)] == currColor) return false;
        }
        return true;
    }
    public static boolean solve(ArrayList<Integer> [] graph,int n, int curr,int m,int[] colors){
        if(curr == n) return true;
        for (int i = 1; i <= m; i++) { //Checking for each solution
           if(isSafe(graph,curr,colors,i)){
               colors[curr] = i;
               if(solve(graph,n,curr+1,m,colors)) return true;
               colors[curr] = 0;
           }
        }
        return false;
    }
    public static boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        //Converting the Adjacency matrix graph to an Adjacency list format
        ArrayList<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(graph[i][j]){
                    g[i].add(j);
                }
            }
        }
//        System.out.println(Arrays.toString(g));
        //Calling solution
        return solve(g,n,0,m,new int[n]);

    }

    public static void main(String[] args) {
        boolean[][] graph = {{false,true,true,true},
                            {true,false,true,false},
                            {true,true,false,true},
                            {true,false,true,false}};
        System.out.println(graphColoring(graph,3,4));
    }
}
