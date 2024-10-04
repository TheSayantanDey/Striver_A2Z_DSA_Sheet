package SubsequencePattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombination {
    public static void getCombinations(String digits,int index,HashMap<Character,String> map,StringBuilder path,List<String> ans){
        if(index>=digits.length()) {
            if (!path.isEmpty())ans.add(new String(path));
            return;
        }

        String letters = map.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            getCombinations(digits,index+1,map,path,ans);
            path.deleteCharAt(path.length()-1);
        }
        return;
    }
    public static List<String> letterCombinations(String digits) {
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> ans = new ArrayList<>();
        getCombinations(digits,0,map,new StringBuilder(),ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
