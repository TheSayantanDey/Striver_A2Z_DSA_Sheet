import java.util.*;
public class PascalsTriangle {
    //Implementing nCr function
    public static int getnCr(int n,int r){
        //nCr = n!/[r!*(n-r)!]
        //We can simplify the value to avoid making factorial function
        //10C3 = 10!/[3!*7!] = (10*9*8)/3! =  (10*9*8)/(3*2*1) = 10/1 * 9/2 * 8/3
        //Using this method we will calculate nCr which will take O(r) time complexity
        int ans = 1;
        for (int i = 0; i < r; i++) {
            ans *= (n-i);
            ans /= (i+1);
        }
        return ans;
    }
    //If you asked to return a specific num of given row and column of the Pascal's triangle
    public static int getNum(int row,int column){
        //Optimal solution
        //Return the nCr value where n = row-1 and r = column-1
        //nCr = n!/[r!*(n-r)!]
        int ans = getnCr(row,column);
        return ans;
    }
    //If you asked to return the whole row as an array from the Pascal's triangle
    public static List<Integer> getRow(int rowIndex){
        List<Integer> ans = new ArrayList<>();
        int elemNumber = rowIndex+1; //0th based indexing, every row will contain rowIndex+1 no of elements
        long elem = 1;
        ans.add((int)elem); //Add first element which will definitely be 1
        for (int i = 1; i <= rowIndex; i++) { //Add rest of the numbers
            elem = elem*(elemNumber-i);
            elem = elem/i;
            ans.add((int)elem);
        }
        return ans;
    }
    public static List<List<Integer>> generateTriangle(int numRows) {

        //My approach
        //Generate the Triangle and initialize every value with 1
//        List<List<Integer>> finalAns = new ArrayList<>();
//        for (int i = 0; i < numRows; i++) {
//            List<Integer> rows = new ArrayList<>();
//            int j=0;
//            while(j<i+1){
//                rows.add(1);
//                j++;
//            }
//            finalAns.add(new ArrayList<>(rows));
//        }
//
//        //Putting the values
//        for (int i = 2; i < numRows; i++) {
//            for (int j = 1; j < finalAns.get(i).size()-1; j++) {
//                int finalValue = finalAns.get(i-1).get(j-1) + finalAns.get(i-1).get(j);
//                finalAns.get(i).set(j,finalValue);
//            }
//        }
//        return finalAns;


        //Striver's Optimal approach
        List<List<Integer>> finalAns = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = getRow(i);
            finalAns.add(new ArrayList<>(temp));
        }
        return finalAns;
    }

    public static void main(String[] args) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        int numRows = 10;
        pascalTriangle = generateTriangle(numRows);
        for (int i = 0; i < numRows; i++) {
            System.out.println(pascalTriangle.get(i));
        }
    }
}
