import java.util.HashMap;

public class SubarraysWithXOR_K {
    public static int subarraysWithXORb(int []nums, int b) {
        // Brute force - Time complexity O(N^2)
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int totalXOR = 0;
//            for (int j = i; j < nums.length; j++) {
//                totalXOR = totalXOR^nums[j];
//                if(totalXOR == b){
//                    count++;
//                }
//            }
//        }
//        return count;

        //Better
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int totalXOR = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            totalXOR ^= nums[i];

            if(map.containsKey(totalXOR^b)){
                count += map.get(totalXOR^b);
            }

            if(!map.containsKey(totalXOR)){
                map.put(totalXOR,1);
            }
            else{
                int mapValue = map.get(totalXOR);
                map.put(totalXOR,mapValue+1);
            }


        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr ={1,2,3,2};
        System.out.println(subarraysWithXORb(arr,2));
    }
}
