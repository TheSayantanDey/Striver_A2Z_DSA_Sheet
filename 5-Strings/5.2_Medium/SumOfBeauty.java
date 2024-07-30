package StringsMedium;

import java.util.HashMap;

public class SumOfBeauty {
    public static int beautySum(String s) {
        int total = 0;
        //Generate all substrings
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character,Integer> map = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                if(map.containsKey(s.charAt(j))) map.put(s.charAt(j), map.get(s.charAt(j))+1);
                else map.put(s.charAt(j),1);

                int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                for(Integer val : map.values()){
                    max = Math.max(val,max);
                    min = Math.min(val,min);
                }
                total += max-min;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(beautySum("aabcbaa"));
    }
}
