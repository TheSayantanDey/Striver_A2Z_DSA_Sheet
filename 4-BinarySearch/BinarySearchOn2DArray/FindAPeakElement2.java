package BinarySearchOn2DArray;

public class FindAPeakElement2 {
    public int[] findPeakGrid(int[][] mat) {
        /*
        //Brute force
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int val = mat[i][j];
                int valLeft = -1,valRight = -1,valUp = -1,valDown = -1;
                if(i-1>=0)valUp = mat[i-1][j];
                if(i+1<mat.length)valDown = mat[i+1][j];
                if(j-1>=0)valLeft = mat[i][j-1];
                if(j+1<mat[0].length)valRight = mat[i][j+1];

                if(val>valLeft && val>valRight && val>valUp && val>valDown){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
        */

        //      n*log(m) approach
        int low = 0, high = mat[0].length-1;
        while(low<=high){
            int mid = (low+high)>>1;

            int max = Integer.MIN_VALUE;
            int maxIndex = -1;

            for (int i = 0; i < mat.length; i++) {
                if(max<mat[i][mid]){
                    max = mat[i][mid];
                    maxIndex = i;
                }
            }
            int valLeft = -1,valRight = -1;
            if(mid-1 >= 0) valLeft = mat[maxIndex][mid-1];
            if(mid+1<mat[0].length) valRight = mat[maxIndex][mid+1];
            if(mat[maxIndex][mid]>valLeft && mat[maxIndex][mid]>valRight){
                return new int[]{maxIndex,mid};
            }else if(mat[maxIndex][mid]<valLeft){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}
