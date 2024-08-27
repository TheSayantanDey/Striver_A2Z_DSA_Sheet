package LL;

public class SearchElement {
    static boolean searchKey(int n, Node head, int key) {
        // Code here
        Node temp = head;
        for(int i=0;i<n;i++){
            if(temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }
}
