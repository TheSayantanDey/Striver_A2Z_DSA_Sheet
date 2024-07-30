package StringsMedium;

public class ImplementAtoi {
//    public static int myAtoi(String s) {
//        StringBuilder answer = new StringBuilder();
//        int start = 0;
//        while(start<s.length() && s.charAt(start)==' ') start++;
//
//        boolean flag = true;
//        if(start<s.length() && (s.charAt(start) == '+' || s.charAt(start) == '-')) {
//            if(s.charAt(start) == '-') flag = false;
//            start++;
//        }
//
//        for (int i = start; i < s.length(); i++) {
//            if (s.charAt(i) > 47 && s.charAt(i) < 58) answer.append(s.charAt(i));
//                else break;
//        }
//
////        System.out.println(answer);
//        if(answer.toString().isEmpty()) return 0;
//        double d = Double.parseDouble(answer.toString());
//        if(!flag) d = -d;
//        if(d>Integer.MAX_VALUE) return Integer.MAX_VALUE;
//        if(d<Integer.MIN_VALUE) return Integer.MIN_VALUE;
//        return (int)d;
//    }

    public static int myAtoi(String s) {
        String s1 = s.trim();
        boolean flag = true;
        if(!s1.isEmpty() && s1.charAt(0) == '-') flag = false;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) > 47 && s1.charAt(i) < 58) sb.append(s1.charAt(i));
            else{
                if(i==0 && s.charAt(i)=='+' || s.charAt(i)=='-');
                else break;

            }
        }

        if(sb.toString().isEmpty()) return 0;
        double d = Double.parseDouble(sb.toString());
        if(!flag) d = -d;
        if(d>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(d<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)d;
    }

    public static void main(String[] args) {
        String s = ".1";
        System.out.println(myAtoi(s));
    }
}
