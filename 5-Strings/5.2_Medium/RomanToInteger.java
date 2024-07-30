package StringsMedium;

import java.util.HashMap;

public class RomanToInteger {
    public static int romanToInt(String s) {
        HashMap<Character,Integer> romanVals = new HashMap<>();
        romanVals.put('I',1);
        romanVals.put('V',5);
        romanVals.put('X',10);
        romanVals.put('L',50);
        romanVals.put('C',100);
        romanVals.put('D',500);
        romanVals.put('M',1000);

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if(i==0 || romanVals.get(s.charAt(i))<=romanVals.get(s.charAt(i-1))){
                ans+=romanVals.get(s.charAt(i));
            }else{
                int preVal = romanVals.get(s.charAt(i-1));
                int currentVal = romanVals.get(s.charAt(i));
                ans -= preVal;
                ans += (currentVal-preVal);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
}
