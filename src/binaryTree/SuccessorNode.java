package binaryTree;

/**
 * Created by Jason Tan on 2022-09-10 15:10
 */
public class SuccessorNode {

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node parent;
        public Node(int val){
            value = val;
        }
    }

    public static Node getSuccessorNode(Node node){
        if (node == null){
            return null;
        }
        //如果node有右树，那么找右树上最左的node，就是当前node的后继节点
        if (node.right != null){
            Node cur = node.right;
            while (cur.left != null){
                cur = cur.left;
            }
            return cur;
        } //如果没有，那么往上遍历parent，如果parent的左节点是当前node那么就返回parent
        //否则就一路向上遍历
        else {
            Node parent = node.parent;
            while (parent != null && parent.left != node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }
}
