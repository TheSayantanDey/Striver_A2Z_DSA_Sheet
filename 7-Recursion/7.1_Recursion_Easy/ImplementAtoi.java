package Recursion_Easy;

public class ImplementAtoi {
    public static String recurAtoi(String s){
        if(s.isEmpty()) return "";
        if(s.charAt(0) >= 48 && s.charAt(0)<=57){
            return s.charAt(0)+recurAtoi(s.substring(1));
        }else{
            return "";
        }
    }
    public static int myAtoi(String s) {
        if(s.isEmpty()) return 0;
        String s1 = s.trim();
        String ans;
        boolean flag = true;
        if(s1.charAt(0) == '+' || s1.charAt(0) == '-'){
            if(s1.charAt(0) == '-') flag = false;
            ans = recurAtoi(s1.substring(1));
        }else ans = recurAtoi(s1);

        if(ans.isEmpty()) return 0;
        double d = Double.parseDouble(ans);
        if(!flag) d = -d;
        if(d>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(d<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)d;
    }
}
