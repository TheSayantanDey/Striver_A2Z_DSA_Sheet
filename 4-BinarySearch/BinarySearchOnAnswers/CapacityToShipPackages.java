package BinarySearchOnAnswers;

public class CapacityToShipPackages {
    public static int shipWithinDays(int[] weights, int days) {
//        //Brute force - linear search
//        int ans = Integer.MAX_VALUE;
//        int minCapacity = Integer.MIN_VALUE;
//        int maxCapacity = 0;
//        for (int i = 0; i < weights.length; i++) {
//            minCapacity = Math.max(minCapacity,weights[i]);
//            maxCapacity += weights[i];
//        }
//        for (int i = minCapacity; i <= maxCapacity; i++) {
//            int requiredDays = 1;
//            int weight = 0;
//            for (int j = 0; j < weights.length; j++) {
//                weight += weights[j];
//                if(weight > i){
//                    requiredDays++;
//                    weight = weights[j];
//                }
//            }
//            if(requiredDays<=days) {
//                ans = i;
//                break;
//            }
//        }
//        return ans;

        //Optimal - Binary search
        int ans = Integer.MAX_VALUE;
        int minCapacity = Integer.MIN_VALUE;
        int maxCapacity = 0;
        for (int i = 0; i < weights.length; i++) {
            minCapacity = Math.max(minCapacity,weights[i]);
            maxCapacity += weights[i];
        }
        while(minCapacity<=maxCapacity){
            int currenCapacity = (minCapacity+maxCapacity)>>1;

            int requiredDays = 1;
            int weight = 0;
            for (int j = 0; j < weights.length; j++) {
                weight += weights[j];
                if(weight > currenCapacity){
                    requiredDays++;
                    weight = weights[j];
                }
            }
            if(requiredDays<=days) {
                ans = currenCapacity;
                maxCapacity = currenCapacity-1;
            }else{
                minCapacity = currenCapacity+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int weights[] = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(weights,days));
    }
}
