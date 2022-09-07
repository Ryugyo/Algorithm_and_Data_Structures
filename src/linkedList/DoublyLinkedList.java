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
        System.out.println('\n');

        Node head2 = new Node(1);
        Node b2 = new Node(2);
        Node c2 = new Node(3);
        head2.next = b2;
        b2.pre = head2;
        b2.next = c2;
        c2.pre = b2;
        Node delete_head = deleteDoubly(head2, 2);
        while(delete_head != null){
            System.out.println(delete_head.pre);
            System.out.println(delete_head.value);
            delete_head = delete_head.next;
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

    //删除单链表上所有指定的值
    public static Node deleteDoubly(Node head, int value){
        while(head != null){
            if (head.value == value){
                head.next.pre = null;
                head = head.next;
            } else{
                break;
            }
        }

        Node new_head = head;
        Node pre = head;
        while(new_head != null){
            if(new_head.value == value){
                pre.next = new_head.next;
                new_head.next.pre = pre;
            } else {
                pre = new_head;
            }
            new_head = new_head.next;
        }
        return head;
    }
}
