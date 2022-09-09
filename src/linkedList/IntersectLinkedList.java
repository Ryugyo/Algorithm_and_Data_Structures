package linkedList;

/**
 * Created by Jason Tan on 2022-09-08 16:39
 */
public class IntersectLinkedList {

    public static Node getFirstLoopNode(Node head){
        //设置快慢指针
        Node fast = head;
        Node slow = head;

        //如果有loop，那么快慢指针必定相遇
        while (slow != fast){
            if (slow.next != null || fast.next != null || fast.next.next != null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        //相遇说明有loop，这时快指针返回head慢指针不动，继续让两者同速度遍历，再次相遇时就是loop的第一个node
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    public static Node noLoop(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return null;
        }

        //如果有相遇，那么两个单链表最后的node肯定是一样的
        Node cur1 = head1;
        int index1 = 0;
        Node cur2 = head2;
        int index2 = 0;
        while (cur1.next != null){
            cur1 = cur1.next;
            index1++;
        }
        while (cur2.next != null){
            cur2 = cur2.next;
            index2++;
        }
        if (cur1 != cur2){
            return null;
        }

        //将length长的赋给cur1，length短的赋给cur2
        cur1 = index1 > index2 ? head1 : head2;
        cur2 = cur1 == head1 ? head2: head1;

        int n = index1 > index2 ? (index1-index2) : (index2-index1);
        //让长的先走，剩下长度一样时同时走，相遇的node就是相交的第一个node
        while (n > 0){
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static Node bothLoop(Node head1, Node head2, Node loop1, Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        //情况1或情况2
        if (loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }

            cur1 = n>0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);

            while (n != 0){
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } //情况3
        else {
            cur1 = loop1.next;
            while(cur1 != loop1){
                if (cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
        }
        //说明没有相交
        return null;
    }

    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }
}
