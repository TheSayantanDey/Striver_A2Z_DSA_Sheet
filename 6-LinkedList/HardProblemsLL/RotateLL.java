package HardProblemsLL;

public class RotateLL {
    public int findLengthLL(Node head){
        if(head == null) return 0;
        int count = 0;
        while (head!=null){
            count++;
            head = head.next;
        }
        return count;
    }
    public Node rotateRight(Node head, int k) {
        //My approach
        /*
        int len = findLengthLL(head);
        if(len ==0) return head;
        k = k%len;
        if(head == null || k==0) return head;
        Node temp = head;
        for (int i = 0; i < k; i++) temp = temp.next;
        Node newTail = head;
        while(temp.next!=null){
            temp = temp.next;
            newTail= newTail.next;
        }
        Node newHead = newTail.next;
        newTail.next = null;
        temp.next = head;
        return newHead;

         */
        //Striver's approach
        // Join the Last nodes next to the first node to make it a circular LL.
        // after that break the list according to the result LL
        int len = findLengthLL(head);
        if(len ==0) return head;
        k = k%len;
        if(head == null || k==0) return head;
        Node temp = head;
        while(temp.next!=null) temp = temp.next;
        temp.next = head;
        int dist =  len-k;
        while(dist-->1) head = head.next;
        Node newHead = head.next;
        head.next = null;
        return newHead;

    }
}
