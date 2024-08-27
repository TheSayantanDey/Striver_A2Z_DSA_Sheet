package LL;

public class AddOne {
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
        return;
    }
    public static Node addOne(Node head) {
        // code here.
        long num = 0;
        Node temp= head;
        while(temp!=null){
            num *= 10;
            num += temp.data;
//            System.out.println(num);
            temp = temp.next;
        }
        long newNum = num+1;
        Node nextNode = null;
        while(newNum>0){
            int digit = (int)(newNum%10);
            newNum = newNum/10;
            Node newNode = new Node(digit);
            newNode.next = nextNode;
            nextNode = newNode;
        }
        return nextNode;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 2, 1, 4, 1, 1, 7, 6, 7, 7, 6};
        Node arrLL = createLL(arr);
        printLL(arrLL);
        printLL(addOne(arrLL));
    }
}
