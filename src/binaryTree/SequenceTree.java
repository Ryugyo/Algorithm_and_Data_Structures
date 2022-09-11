package binaryTree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jason Tan on 2022-09-10 15:43
 */
public class SequenceTree {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    public static Node reconByPreString(String sequence){
        String[] values = sequence.split("_");

        //将序列string的每一个字符添加进queue里
        Queue<String> queue = new LinkedList<String>();
        Collections.addAll(queue, values);
        return reconPreOrder(queue);
    }

    public static Node reconPreOrder(Queue<String> queue){
        //#代表null，其他代表每个node的value
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }

        //构建haed，随后构建左树再来右树
        Node head = new Node(Integer.parseInt(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
}
