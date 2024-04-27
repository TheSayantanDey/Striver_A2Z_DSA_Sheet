package BinarySearchOnAnswers;

public class SquareRoot {
    public static int floorSqrt(int n)
    {
        int floor = -1;
        int low = 0,high = n;
        while(low<=high){
            int mid = (low+high)>>1;

            long square = (long) mid *mid;
            if(square <= n){
                floor = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return floor;
    }

    public static void main(String[] args) {
        System.out.println(floorSqrt(6));
    }
}
