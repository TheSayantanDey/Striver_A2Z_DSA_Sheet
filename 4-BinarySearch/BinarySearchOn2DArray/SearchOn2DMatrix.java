package BinarySearchOn2DArray;

public class SearchOn2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0, high = (m*n) -1;
        while(low<=high){
          int mid = (low+high)>>1;
          int i = mid/m;
          int j = mid%m;
          if(target>matrix[i][j]){
              low = mid+1;
          }else if(target<matrix[i][j]){
              high = mid-1;
          }else{
              return true;
          }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix ={{1,3,5,7},{10,11,15,20},{23,30,34,60}};
        System.out.println(searchMatrix(matrix,4));
    }
}
