package Recursion_Hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    //TLE in LEETCODE - only possible solution using recursion
    public static boolean isBreakable(String s,int index,HashSet<String> set){
        if(index==s.length()) return true;
        for (int i = index+1; i <= s.length(); i++) { // <= s.length() cause to check even the substring with last char
            if(set.contains(s.substring(index,i))){
                if(isBreakable(s,i,set))return true;
            }
        }
        return false;
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return isBreakable(s,0,set);
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> dict = new ArrayList<>();
        dict.add("apple");
        dict.add("pen");
        System.out.println(wordBreak(s,dict));
    }
}
