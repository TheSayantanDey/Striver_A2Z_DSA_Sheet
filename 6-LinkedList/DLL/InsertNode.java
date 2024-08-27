package DLL;

public class InsertNode {
    void addNode(Node head_ref, int pos, int data)
    {
        int currPos = 0;
        Node temp = head_ref;
        Node newNode = new Node(data);
        while(currPos != pos){
            temp = temp.next;
            currPos++;
        }
        if(temp.next == null) newNode.next = null;
        else newNode.next = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
        if(newNode.next != null) newNode.next.prev = newNode;
    }
}
