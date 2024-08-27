package MediumProblemsDLL;

public class removeDuplicatesFromSortedDLL {
    Node removeDuplicates(Node head){
        /*
        Node temp = head.next;
        while (temp!=null){
            if(temp.data == temp.prev.data){
                //Remove temp
                temp.prev.next = temp.next;
                if(temp.next!=null) temp.next.prev = temp.prev;
            }
            temp = temp.next;
        }
        return head;

         */

        //More optimising
        Node temp = head;
        Node nextPointer = head.next;
        while(nextPointer!=null){
            if(temp.data == nextPointer.data){
                nextPointer = nextPointer.next;
            }else{
                temp.next = nextPointer;
                nextPointer.prev = temp;
                temp = nextPointer;
            }
        }
        temp.next = nextPointer;
        return head;
    }
}
