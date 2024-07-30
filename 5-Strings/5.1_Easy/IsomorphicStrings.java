package StringsEasy;

import java.util.HashMap;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
//        if(s.length() != t.length()) return false;
//        HashMap<Character,Character> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            if(map.containsKey(s.charAt(i))){
//                char val = map.get(s.charAt(i));
//                if(val != t.charAt(i)) return false;
//            }else{
//                map.put(s.charAt(i),t.charAt(i));
//            }
//        }
//        //Check the other way around too
//        HashMap<Character,Character> map2 = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            if(map2.containsKey(t.charAt(i))){
//                char val = map2.get(t.charAt(i));
//                if(val != s.charAt(i)) return false;
//            }else{
//                map2.put(t.charAt(i),s.charAt(i));
//            }
//        }
//        return true;

        //Optimising the above one
        if(s.length() != t.length()) return false;
        HashMap<Character,Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) != t.charAt(i)) return false;
            }else{
                if(map.containsValue(t.charAt(i))) return false; //This line saves the time and space for checking the other way around
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "badc";
        String t = "kikp";
        System.out.println(isIsomorphic(s,t));
    }
}
