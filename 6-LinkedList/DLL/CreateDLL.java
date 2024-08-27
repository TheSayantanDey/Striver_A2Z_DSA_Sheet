package DLL;

public class CreateDLL {
    Node constructDLL(int arr[]) {
        // Code here
        Node head = new Node(arr[0]);
        Node curr = head;
        for(int i=1;i<arr.length;i++){
            Node nextNode = new Node(arr[i]);
            curr.next = nextNode;
            nextNode.prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
