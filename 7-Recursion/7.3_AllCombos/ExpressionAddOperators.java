package Recursion_Hard;
import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public static void solve(String num,int index,String path,long preAns,long preVal,int target,List<String> answer){
         if(index==num.length()) {
//             System.out.println(path);
             if(preAns==target && !path.isEmpty()) answer.add(path);
             return;
         }

        for (int i = index; i < num.length(); i++) {
            if(i>index && num.charAt(index)=='0') break; //Skipping the numbers with leading zeros
            long curr = Long.parseLong(num.substring(index,i+1));

            if(path.isEmpty()){
                solve(num,i+1,path+curr,curr,curr,target,answer);
            }else{
                // doing +
                solve(num,i+1,path+"+curr",preAns+curr,curr,target,answer);

                // doing -
                solve(num,i+1,path+"-curr",preAns-curr,-curr,target,answer);

                // doing *
                solve(num,i+1,path+"*curr",(preAns-preVal)+(preVal*curr),preVal*curr,target,answer);
            }

        }
    }
    public static List<String> addOperators(String num, int target) {
        List<String> answer = new ArrayList<>();
        solve(num,0,"",0,0,target,answer);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(addOperators("3456237490",9191));

    }
}
