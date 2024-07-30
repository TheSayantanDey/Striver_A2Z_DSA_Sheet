package StringsEasy;

public class LargestOddNumber {
    public static String largestOddNumber(String num) {
        int end = -1;
        for (int i = num.length()-1; i >= 0; i--) {
            int val = num.charAt(i);
            if(val%2==1) {
                end = i;
                break;
            }
        }
        return num.substring(0,end+1);
    }

    public static void main(String[] args) {
        String num = "5504";
        System.out.println(largestOddNumber(num));
    }
}
