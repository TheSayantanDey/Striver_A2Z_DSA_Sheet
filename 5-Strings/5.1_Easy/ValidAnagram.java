package StringsEasy;

import java.util.Arrays;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
//        if(s.length() != t.length()) return false;
//        char[] s1 = s.toCharArray();
//        char[] t1 = t.toCharArray();
//        Arrays.sort(s1);
//        Arrays.sort(t1);
//        System.out.println(Arrays.toString(s1));
//        System.out.println(Arrays.toString(t1));
//        for (int i = 0; i < s1.length; i++) {
//            if(s1[i] != t1[i]) return false;
//        }
//        return true;

        //Alternative approach - Using a frequency Array
        if(s.length()!=t.length()) return false;
        int[] frequencyArrray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequencyArrray[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            frequencyArrray[t.charAt(i)-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if(frequencyArrray[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(isAnagram(s,t));
    }
}
