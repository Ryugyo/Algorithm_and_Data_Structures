package binaryTree;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Jason Tan on 2022-09-09 21:18
 */
public class LowestCommonAncestor {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    //head是头，o1和o2一定属于head
    public static Node lca(Node head, Node o1, Node o2){
        //生成一个记录当前node和它父node的表，
        HashMap<Node, Node> fatherMap = new HashMap<>();
        //process方法将所有node都和父node存一起
        process(head, fatherMap);

        //另建一个hashset，储存o1
        HashSet<Node> set1 = new HashSet<>();

        Node cur = o1;
        //将o1放入循环，如果没到顶部root，就一直往上走，这样循环完set1就储存了从o1往上到root全部node
        while(cur != head){
            set1.add(cur);
            cur = fatherMap.get(cur);
        }
        set1.add(head);

        //再将cur设置为o2然后继续向上遍历，当cur和set1中某值第一次重复就是o1和o2的最早祖先
        cur = o2;
        while (cur != head){
            if (set1.contains(cur)){
                return cur;
            }
            cur = fatherMap.get(cur);
        }
        return null;
    }

    public static void process(Node head, HashMap<Node, Node> fatherMap){
        if (head == null){
            return;
        }
        fatherMap.put(head.left, head);
        fatherMap.put(head.right, head);
        process(head.left, fatherMap);
        process(head.right, fatherMap);
    }
}
