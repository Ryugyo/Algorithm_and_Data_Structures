package linkedList;

/**
 * Created by Jason Tan on 2022-09-08 15:34
 */
public class PalindromeList {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        System.out.println(ifPalindrome(head));
    }

    public static boolean ifPalindrome(Node head){
        //快慢指针
        Node fast = head;
        Node slow = head;
        while(slow.next != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //此时fast在list末尾，slow在list中间
        fast = slow.next; //中间往右第一个node
        slow.next = null;

        //将右半段逆转
        Node next;
        while (fast != null){
            next = fast.next;
            fast.next = slow;
            slow = fast;
            fast = next;
        }

        //此时slow达到右侧第一位node，将fast也重新设置到左侧第一位
        fast = head;

        while (fast != null && slow != null){
            System.out.println(fast.value);
            System.out.println(slow.value);
            if (fast.value != slow.value){
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }
}
