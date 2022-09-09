package binaryTree;

import linkedList.PalindromeList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jason Tan on 2022-09-08 19:56
 */
public class FindMaxWidth {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        head.left = b;
        head.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        System.out.println(maxWidth(head));
    }

    public static int maxWidth(Node root){
        if (root == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        //准备一个hashmap记录每个node所在的层数
        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(root, 1);
        //记录当前在第几层
        int curLevel = 1;
        //记录当前层发现了多少node
        int curLevelNodes = 0;
        //记录哪一个层数的node数是最多的
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            //得出当前node所在的层
            int curNodeLevel = levelMap.get(cur);
            //如果当前node所在层数和当前层数一致，当前层数总node数量+1
            if (curNodeLevel == curLevel){
                curLevelNodes ++;
                if (queue.isEmpty()){
                    max = Math.max(max, curLevelNodes);
                }
            } //如果当前node所在层和当前层不一致，只可能是queue已经遍历到下一层的node了
            else {
                //这种情况下，将这一层统计到的全部node数和之前的max比较，若更大就替换
                max = Math.max(max, curLevelNodes);
                curLevel ++;
                curLevelNodes = 1;
            }
            if (cur.left != null){
                levelMap.put(cur.left, curLevel+1);
                queue.add(cur.left);
            }
            if (cur.right != null){
                levelMap.put(cur.right, curLevel+1);
                queue.add(cur.right);
            }
        }

        return max;
    }

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

}
