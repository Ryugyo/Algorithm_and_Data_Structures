package binaryTree;

/**
 * Created by Jason Tan on 2022-09-09 19:29
 */
public class IsBinarySearchTree {

    public static void main(String[] args) {
        Node head = new Node(4);
        Node b = new Node(2);
        Node c = new Node(6);
        Node d = new Node(1);
        Node e = new Node(3);
        Node f = new Node(5);
        Node g = new Node(7);
        head.left = b;
        head.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        System.out.println(isSearchTree(head));
    }

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    public static int cur = 0;

    public static boolean isSearchTree(Node root){
        if (root == null){
            return true;
        }
        boolean isLeft = isSearchTree(root.left);
        if (!isLeft){
            return false;
        }
        if (root.value > cur){
            cur = root.value;
        } else {
            return false;
        }
        return isSearchTree(root.right);
    }

    //递归套路
    //1.列出满足搜索二叉树的条件
    public static class ReturnData{
        public boolean isBST;
        public int min;
        public int max;
        public ReturnData(boolean is, int mi, int ma){
            isBST = is;
            min = mi;
            max = ma;
        }
    }

    //2.构造递归
    public static ReturnData isSearchTree2(Node head){
        if (head == null){
            return null;
        }
        ReturnData left = isSearchTree2(head.left);
        ReturnData right = isSearchTree2(head.right);

        //获取最大最小数
        int min = head.value;
        int max = head.value;
        if (left != null){
            min = Math.min(min, left.min);
            max = Math.max(max, left.max);
        }
        if (right != null){
            min = Math.min(min, right.min);
            max = Math.max(max, right.max);
        }

        //判断当前是否为false，左边最小是否大于当前，右边最大是否小于当前，左右是否false
        boolean isBST = left == null || (left.isBST && left.max < head.value);
        if (right!=null && (!right.isBST || head.value>= right.min)) {
            isBST = false;
        }
        return new ReturnData(isBST, min, max);
    }
}
