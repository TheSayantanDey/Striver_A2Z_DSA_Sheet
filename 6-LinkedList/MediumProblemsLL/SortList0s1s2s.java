package MediumProblemsLL;

public class SortList0s1s2s {
    static Node segregate(Node head) {
        Node zeroHead = null;
        Node zeroTail = null;
        Node oneHead = null;
        Node oneTail = null;
        Node twoHead = null;
        Node twoTail = null;
        Node temp = head;
        while (temp!=null){
            if(temp.data == 0){
                if(zeroHead == null) {
                    zeroHead = temp;
                    zeroTail = zeroHead;
                }else{
                    zeroTail.next = temp;
                    zeroTail = zeroTail.next;
                }
            }else if(temp.data == 1){
                if(oneHead == null) {
                    oneHead = temp;
                    oneTail = oneHead;
                }else{
                    oneTail.next = temp;
                    oneTail = oneTail.next;
                }
            }else{
                if(twoHead == null) {
                    twoHead = temp;
                    twoTail = twoHead;
                }else{
                    twoTail.next = temp;
                    twoTail = twoTail.next;
                }
            }
            temp = temp.next;
        }

        if(zeroHead==null) zeroHead = oneHead;
        else zeroTail.next = oneHead;

        if(oneTail == null) {
            if(zeroHead == null) zeroHead = twoHead;
            else zeroTail.next = twoHead;
        }
        else oneTail.next = twoHead;

        if(twoHead != null) twoTail.next = null;
        return zeroHead;
    }

    public static Node createLL(int[] arr){
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }
    public static void printLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {0,1,1,1,0};
        Node LL = createLL(arr);
        printLL(LL);
        Node sortedLL = segregate(LL);
        printLL(sortedLL);
    }
}
