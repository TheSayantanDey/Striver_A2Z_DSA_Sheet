package MediumProblemsLL;

public class SegrregateOddEvenNodes {
    public Node oddEvenList(Node head) {
        if(head==null || head.next == null) return head;

        Node oddHead = head;
        Node oddTail = head;
        Node evenHead = head.next;
        Node evenTail = head.next;
        Node temp = head.next.next;
        boolean isPosOdd = true;
        while(temp!=null){
            if(isPosOdd){
                oddTail.next = temp;
                oddTail = oddTail.next;
                isPosOdd = false;
            }else{
                evenTail.next = temp;
                evenTail = evenTail.next;
                isPosOdd = true;
            }
            temp = temp.next;
        }
        oddTail.next = evenHead;
        evenTail.next = null;
        return oddHead;
    }
}
