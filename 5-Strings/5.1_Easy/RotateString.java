package StringsEasy;

public class RotateString {
    public static boolean rotateString(String s, String goal) {
//        if(s.length() != goal.length()) return false;
//        char firstChar = s.charAt(0);
//        for (int i = 0; i < goal.length(); i++) {
//            if(goal.charAt(i)==firstChar){
//                int flag = 0;
//                for (int j = 0; j < s.length(); j++) {
//                    if(s.charAt(j) == goal.charAt((i+j)%goal.length())){
//                        flag = 1;
//                    }else{
//                        flag = 0;
//                        break;
//                    }
//                }
//                if(flag == 1) return true;
//            }
//        }
//        return false;


        //Alternate approach
        if(s.length() != goal.length()) return false;
        StringBuilder s1 = new StringBuilder();
        s1.append(s);
        s1.append(s);
        String newS = new String();
        newS = s1.toString();
        return newS.contains(goal);
    }

    public static void main(String[] args) {
        String  s = "abcde";
        String  goal = "cdeab";
        System.out.println(rotateString(s,goal));

    }
}
