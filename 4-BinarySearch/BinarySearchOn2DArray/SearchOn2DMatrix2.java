package BinarySearchOn2DArray;

public class SearchOn2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
        //Brute force
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==target) return true;
            }
        }
        return false;

         */
        /*
        //Better Approach
        for (int i = 0; i < matrix.length; i++) {
            int low = 0,high= matrix[0].length-1;
            while(low<=high){
                int mid = (low+high)>>1;
                if(matrix[i][mid] == target) return true;
                else if(matrix[i][mid] > target) high = mid-1;
                else low = mid+1;
            }
        }
        return false;
         */

        //Optimal Approach
        //We start from the corner matrix[0][matrix[0].length]
        int i = 0, j = matrix[0].length-1;
        while(i<matrix.length && j>=0){
          if(matrix[i][j] == target) return true;
          else if(matrix[i][j] > target) j--;
          else i++;
        }
        return false;
    }
}
