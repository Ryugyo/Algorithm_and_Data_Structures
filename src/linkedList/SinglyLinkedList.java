package linkedList;

/**
 * Created by Jason Tan on 2022-09-05 22:35
 */
public class SinglyLinkedList {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        head.next = b;
        b.next = c;

        Node rev_head = reverseSingly(head);
        while(rev_head != null){
            System.out.println(rev_head.value);
            rev_head = rev_head.next;
        }
    }

    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    //反转单链表
    public static Node reverseSingly(Node head){
        Node pre = null;
        Node next;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //
}
