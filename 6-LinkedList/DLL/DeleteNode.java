package DLL;

public class DeleteNode {
    public Node deleteNode(Node head, int x) {
        if(x==1){
            head.next.prev = null;
            head = head.next;
            return head;
        }

        Node temp = head.next;
        int pos = 2;
        while(pos!=x){
            temp = temp.next;
            pos++;
        }
        if(temp.next == null) temp.prev.next = null;
        else{
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        return head;
    }
}
