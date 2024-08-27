package HardProblemsLL;

class Node1{
    int data;
    Node1 next;
    Node1 bottom;
    Node1(int val){
        data = val;
        next = null;
        bottom = null;
    }

}
public class FlatteningTheLL {
    public static Node mergeTwoSortedLists(Node head, Node newHead){
        Node finalHead = null;
        Node finalHeadPointer = finalHead;
        Node headPointer = head;
        Node newHeadPointer = newHead;
        while (headPointer != null && newHeadPointer != null){
            if(headPointer.data < newHeadPointer.data){
                if(finalHeadPointer == null){
                    finalHead = headPointer;
                    finalHeadPointer = finalHead;
                }else{
                    finalHeadPointer.bottom = headPointer;
                    finalHeadPointer = finalHeadPointer.bottom;
                }
                headPointer = headPointer.bottom;
            }else{
                if(finalHeadPointer == null){
                    finalHead = newHeadPointer;
                    finalHeadPointer = finalHead;
                }else{
                    finalHeadPointer.bottom = newHeadPointer;
                    finalHeadPointer = finalHeadPointer.bottom;
                }
                newHeadPointer = newHeadPointer.bottom;
            }
        }
        if(headPointer == null){
            if(finalHeadPointer == null) finalHead = newHeadPointer;
            else finalHeadPointer.bottom = newHeadPointer;
        }
        else{//newHeadPointer == null
            if(finalHeadPointer == null) finalHead = headPointer;
            else finalHeadPointer.bottom = headPointer;
        }
        return finalHead;
    }
    Node flatten(Node root) {
        if(root.next == null){
            return root;
        }
        Node prevAns = flatten(root.next);
        return mergeTwoSortedLists(root,prevAns);
    }
}
