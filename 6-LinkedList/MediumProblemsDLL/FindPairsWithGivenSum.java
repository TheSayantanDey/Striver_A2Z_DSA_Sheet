package MediumProblemsDLL;

import java.util.ArrayList;

public class FindPairsWithGivenSum {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        Node tail = head;
        while(tail.next!=null) tail = tail.next;
        while (head!=tail){
            int val = head.data+tail.data;
            if(val==target){
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(head.data);
                pair.add(tail.data);
                pairs.add(new ArrayList<>(pair));
                tail = tail.prev;
            }else if(val<target) head = head.next;
            else tail = tail.prev;
        }
        return pairs;
    }
}
