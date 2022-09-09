package binaryTree;

import linkedList.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Jason Tan on 2022-09-08 18:04
 */
public class BinaryTree {

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

        xianxuTree(head);
        System.out.println("==========================");
        zhongxuTree(head);
        System.out.println("==========================");
        houxuTree(head);
        System.out.println("==========================");
        xianxuStack(head);
        System.out.println("==========================");
        zhongxuStack(head);
        System.out.println("==========================");
        houxuStack(head);
        System.out.println("==========================");
        widthSearch(head);
    }

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    public static void searchTree(Node root){
        if (root == null){
            return;
        }
        searchTree(root.left);
        searchTree(root.right);
    }

    //先序遍历
    public static void xianxuTree(Node root){
        if (root == null){
            return;
        }
        System.out.println(root.value);
        xianxuTree(root.left);
        xianxuTree(root.right);
    }

    //中序遍历
    public static void zhongxuTree(Node root){
        if (root == null){
            return;
        }
        zhongxuTree(root.left);
        System.out.println(root.value);
        zhongxuTree(root.right);
    }

    //后序遍历
    public static void houxuTree(Node root){
        if (root == null){
            return;
        }
        houxuTree(root.left);
        houxuTree(root.right);
        System.out.println(root.value);
    }

    //无递归先序
    public static void xianxuStack(Node root){
        if (root != null){
            Stack<Node> stack = new Stack<Node>();
            stack.add(root);
            while (!stack.isEmpty()){
                root = stack.pop();
                System.out.println(root.value);
                if (root.right != null){
                    stack.add(root.right);
                }
                if (root.left != null){
                    stack.add(root.left);
                }
            }
        }
    }

    //无递归中序
    public static void zhongxuStack(Node root){
        if (root != null){
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || root != null){
                if (root != null){
                    stack.add(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.println(root.value);
                    root = root.right;
                }
            }
        }
    }

    //无递归后序
    public static void houxuStack(Node root){
        if (root != null){
            Stack<Node> stack1 = new Stack<Node>();
            Stack<Node> stack2 = new Stack<Node>();
            stack1.add(root);
            while (!stack1.isEmpty()){
                root = stack1.pop();
                stack2.add(root);
                if (root.left != null){
                    stack1.add(root.left);
                }
                if (root.right != null){
                    stack1.add(root.right);
                }
            }

            while (!stack2.isEmpty()){
                root = stack2.pop();
                System.out.println(root.value);
            }
        }
    }

    //宽度遍历
    public static void widthSearch(Node root){
        if (root != null){
            //java自带的linkedlist可以作为queue使用
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                Node cur = queue.poll();
                System.out.println(cur.value);
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
            }
        }
    }
}
