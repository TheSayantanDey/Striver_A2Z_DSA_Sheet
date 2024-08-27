package MediumProblemsLL;

public class RemoveNthNodeFromTheBack {
    public Node removeNthFromEnd(Node head, int n) {
        Node temp = head;
        int pos = 0;
        while(pos<n){
            temp = temp.next;
            pos++;
        }
        Node targetNode = head;
        Node prevNode = null;
        while(temp != null){
            temp = temp.next;
            prevNode = targetNode;
            targetNode = targetNode.next;
        }
        if(prevNode == null) return targetNode.next;

        prevNode.next = targetNode.next;
        return head;


    }
}
