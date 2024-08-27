package MediumProblemsDLL;

public class DeleteAllOccurrences {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        while(head!=null && head.data == x){
            head = head.next;
            head.prev = null;
        }
        Node temp = head;
        while (temp!=null){
            if(temp.data == x){
                temp.prev.next = temp.next;
                if(temp.next!=null) temp.next.prev = temp.prev;
            }
            temp = temp.next;
        }
        return head;
    }
}
