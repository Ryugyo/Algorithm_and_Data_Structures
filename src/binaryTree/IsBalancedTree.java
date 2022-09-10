package binaryTree;

/**
 * Created by Jason Tan on 2022-09-09 20:11
 */
public class IsBalancedTree {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    //为了判断是否是平衡树，需要两个信息，（子树）是否是平衡树和（子树）的高度
    //为此创造一个datatype，包含这两个信息
    public static class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isB, int height){
            isBalanced = isB;
            this.height = height;
        }
    }

    public static ReturnType isBalanced(Node head){
        if(head == null){
            return new ReturnType(true, 0);
        }

        //返回left tree和right tree的信息
        ReturnType leftTree = isBalanced(head.left);
        ReturnType rightTree = isBalanced(head.right);

        //当前node的height是左树和右树最高那个的高度再+1
        int height = Math.max(leftTree.height, rightTree.height) +1;

        //判断当前node是否为平衡树？满足三个条件：左和右高度最多差2，左是平衡，右是平衡
        boolean isBalanced = leftTree.isBalanced && rightTree.isBalanced
                && Math.abs(leftTree.height - rightTree.height) < 2;

        //返回两个信息给更上层（如果有）
        return new ReturnType(isBalanced, height);
    }
}
