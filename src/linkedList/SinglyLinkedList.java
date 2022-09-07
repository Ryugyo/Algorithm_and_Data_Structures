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
            System.out.print(rev_head.value);
            rev_head = rev_head.next;
        }
        System.out.println('\n');

        Node head2 = new Node(1);
        Node b2 = new Node(2);
        Node c2 = new Node(3);
        head2.next = b2;
        b2.next = c2;
        Node delete_head = deleteSingly(head2, 2);
        while(delete_head != null){
            System.out.print(delete_head.value);
            delete_head = delete_head.next;
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

    //删除单链表上所有指定的值
    public static Node deleteSingly(Node head, int value){
        while(head != null){
            if (head.value == value){
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
            } else {
                pre = new_head;
            }
            new_head = new_head.next;
        }
        return head;
    }
}
