package binaryTree;

import java.util.LinkedList;

/**
 * Created by Jason Tan on 2022-09-09 19:41
 */
public class IsCompleteTree {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    public static boolean isComplete(Node head){
        if (head == null){
            return true;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);

        boolean leaf = false;
        Node l = null;
        Node r = null;
        while (!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;
            //如果有右无左直接返回false
            //如果已经遇到过一次左右不全的node，那么它之后的所有node都必须是leaf（也就是都不能有left和right）
            if ((leaf && (l != null || r != null)) || (l == null && r != null)){
                return false;
            }

            if (l != null){
                queue.add(l);
            }
            if (r != null){
                queue.add(r);
            }
            if (l == null || r == null){
                leaf = true;
            }
        }
        return true;
    }
}
