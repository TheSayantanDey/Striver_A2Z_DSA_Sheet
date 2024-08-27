package DLL;

public class ReverseADLL {
    public static Node reverseDLL(Node  head)
    {
        Node temp1 = head;
        while(temp1!=null){
            Node temp2 = temp1.next;

            temp1.next = temp1.prev;
            temp1.prev = temp2;

            if(temp1.prev == null) break;
            temp1 = temp1.prev;
        }
        return temp1;
    }
}
