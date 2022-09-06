package linkedList;

/**
 * Created by Jason Tan on 2022-09-05 23:00
 */
public class DoublyLinkedList {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        head.next = b;
        b.pre = head;
        b.next = c;
        c.pre = b;

        Node rev_head = reverseDoubly(head);
        while(rev_head != null){
            System.out.println(rev_head.pre);
            System.out.println(rev_head.value);
            rev_head = rev_head.next;
        }
    }

    public static class Node{
        public int value;
        public Node next;
        public Node pre;

        public Node(int value){
            this.value = value;
        }
    }

    //反转双链表
    public static Node reverseDoubly(Node head){
        Node pre = null;
        Node next;
        while(head!=null){
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    //
}
