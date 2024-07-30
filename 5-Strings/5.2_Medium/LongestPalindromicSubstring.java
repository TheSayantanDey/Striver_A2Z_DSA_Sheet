package StringsMedium;

public class LongestPalindromicSubstring {
//    public static boolean checkPalindrome(String s, int start, int end){
//        while(start<=end){
//            if(s.charAt(start) != s.charAt(end)) return false;
//            start++;
//            end--;
//        }return true;
//    }
//    public static String longestPalindrome(String s) {
//        int start = 0,end = 0;
//        int maxLen = 0;
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i; j < s.length(); j++) {
//                boolean flag = false;
//                if(s.charAt(i) == s.charAt(j)) flag = checkPalindrome(s,i,j);
//                if(flag){
//                    int len = j-i+1;
//                    if(len>maxLen){
//                        maxLen = len;
//                        start = i;
//                        end = j;
//                    }
//                }
//            }
//        }
//        return s.substring(start,end+1);
//    }

    public static String checkForOddWay(String s,int index){
        int start = index,end = index;
        int startOutOfBound = 0, endOutOfBound = 0;
        while(start>=0 && end<s.length()){
            if(s.charAt(start) != s.charAt(end)) break;
            start--;
            end++;
        }
        start++;end--;
        return s.substring(start,end+1);
    }
    public static String checkForEvenWay(String s, int index){
        int start = index,end = index+1;
        while(start>=0 && end<s.length()){
            if(s.charAt(start) != s.charAt(end)) break;
            start--;
            end++;
        }
        start++;
        end--;
        return s.substring(start,end+1);
    }
    public static String longestPalindrome(String s) {
        int maxLen = 0;
        String ans = null;
        for (int i = 0; i < s.length(); i++) {
            String s1 = checkForOddWay(s,i);
            String s2 = checkForEvenWay(s,i);
            if(s1.length()>s2.length()){
                if(s1.length()>maxLen){
                    ans = s1;
                    maxLen = s1.length();
                }
            }else{
                if(s2.length()>maxLen){
                    ans = s2;
                    maxLen = s2.length();
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
