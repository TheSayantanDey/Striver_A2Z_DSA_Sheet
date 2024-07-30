package StringsMedium;

import java.util.HashMap;
import java.util.SimpleTimeZone;
import java.util.Stack;

public class CountWithKDifferentCharacters {
    //Time: O(n^2) , Space: O(n)
//    public static int countSubStrings(String str, int k) {
//        int ans = 0;
//        for (int i = 0; i < str.length(); i++) {
//            HashMap<Character,Integer> map = new HashMap<>();
//            for (int j = i; j < str.length(); j++) {
//                if(map.containsKey(str.charAt(j))){
//                    int val = map.get(str.charAt(j));
//                    map.put(str.charAt(j),++val);
//                }
//                else{
//                    map.put(str.charAt(j),1);
//                }
//
//                if(map.size()==k) ans++;
//                else if(map.size()>k) break;
//            }
//        }
//        return ans;
//    }

//Time: O(n), Space:O(1)
//    public static int countSubStrings(String str, int k) {
//        int ans = 0;
//        for (int i = 0; i < str.length(); i++) {
//            int[] arr = new int[26];
//            int unique = 0;
//            for (int j = i; j < str.length(); j++) {
//                int currentIndex = str.charAt(j) - 'a';
//                if(arr[currentIndex] == 0) unique++;
//                arr[currentIndex]++;
//
//                if(unique==k) ans++;
//                else if(unique>k) break;
//            }
//        }
//        return ans;
//    }


//Optimal - Time: O(N) Space: O(1)
    public static int countSubStrings(String str, int k){
        return atMostK(str,k)-atMostK(str,k-1);
    }
    public static int atMostK(String str, int k){
        int ans = 0;
        int left=0,right=0;
        int unique=0;
        int[] freqArr = new int[26];
        while(right<str.length()){
            if(freqArr[str.charAt(right)-'a'] == 0) unique++;
            freqArr[str.charAt(right)-'a']++;

            while (unique>k){
                freqArr[str.charAt(left)-'a']--;
                if(freqArr[str.charAt(left)-'a'] == 0) unique--;
                left++;
            }

            ans += right-left+1;
            right++;
        }
        return ans;
    }
    public static void main(String[] args) {
        String s ="abcad";
        System.out.println(countSubStrings(s,3));
    }
}
