package BinarySearchOnAnswers;

public class MakeBouquets {
    public static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i],max);
        }
        return max;
    }
    public static int findMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(arr[i],min);
        }
        return min;
    }
    public static int minDays(int[] bloomDay, int m, int k) {
//        //Brute force
//        int minDays = findMin(bloomDay);
//        int maxDays = findMax(bloomDay);
//        for (int i = minDays; i <= maxDays; i++) { //i=3
//            int flowers = 0;
//            int bouquets = 0;
//            for (int j = 0; j < bloomDay.length; j++) {
//                if(bloomDay[j]<=i) {
//                    flowers++;
//                    if(flowers == k){
//                        bouquets++;
//                        flowers = 0;
//                    }
//                }else flowers = 0;
//            }
//            if(bouquets>=m) return i;
//        }
//        return -1;

        //Binary Search
        int minDays = findMin(bloomDay);
        int maxDays = findMax(bloomDay);
        int ans = -1;
        while(minDays<=maxDays){
            int currentDays = (minDays+maxDays)>>1;
            int flowers = 0;
            int bouquets = 0;
            for (int j = 0; j < bloomDay.length; j++) {
                if(bloomDay[j]<=currentDays) {
                    flowers++;
                    if(flowers == k){
                        bouquets++;
                        flowers = 0;
                    }
                }else flowers = 0;
            }
            if(bouquets>=m) {
                ans =  currentDays;
                maxDays = currentDays-1;
            }else if(bouquets<m){
                minDays = currentDays+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] bloomday = {7,7,7,7,12,7,7};
        int m = 2 ,k = 3;
        System.out.println(minDays(bloomday,m,k));
    }
}
