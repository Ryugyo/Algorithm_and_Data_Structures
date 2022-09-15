package disjointSet;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by Jason Tan on 2022-09-14 19:27
 */
public class DisjointSet {

    public static class Node<V>{
        V value;

        public Node(V value){
            this.value = value;
        }
    }

    public static class UnionSet<V> {
        //记录所有的nodes
        public HashMap<V, Node<V>> nodes;
        //记录所有node指针指向的father
        public HashMap<Node<V>, Node<V>> parents;
        //只有一个点是代表点的时候才有记录，记录所有代表点所属的集合长度
        public HashMap<Node<V>, Integer> sizeMap;

        public UnionSet(List<V> values){
            //初始化先把所有值每个建一个node然后放入nodes，再把他们放入parents，father是他们自己
            for (V value : values){
                Node<V> node = new Node<>(value);
                nodes.put(value, node);
                parents.put(node, node);
                //每一个点一开始都是代表点，一开始所在集合内只有他们自己所以都是1
                sizeMap.put(node, 1);
            }
        }

        public Node<V> findFather(Node<V> cur){
            //找cur的最上层的father，但是沿途所有经过的node的指针都指向最终的father（优化）
            //有了这个优化，所有途径的点都连接在father上，下一次寻找的话只需往上一层便可找到，大大节省了时间
            Stack<Node<V>> path = new Stack<>();
            while (cur != parents.get(cur)){
                //将沿途node加入path stack
                path.push(cur);
                cur = parents.get(cur);
            }
            //path不为空，就pop出然后全部指向father
            while (!path.isEmpty()){
                parents.put(path.pop(), cur);
            }
            return cur;
        }

        public boolean isSameSet(V a, V b){
            //如果a和b没记录，直接false
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return false;
            }
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        public void union(V a, V b){
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return;
            }
            //找到a和b的father
            Node<V> aHead = findFather(nodes.get(a));
            Node<V> bHead = findFather(nodes.get(b));

            //如果两个head一样说明a和b就在一个集合里，就不需要union了
            if(aHead != bHead){
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                //如果b所在集合是小集合（elem数少）
                if (aSetSize >= bSetSize){
                    //将a的head指向b的head
                    parents.put(bHead, aHead);
                    //更新bHead的集合长度
                    sizeMap.put(aHead, aSetSize+bSetSize);
                    //移除aHead的记录（因为此时aHead已经不再是代表点）
                    sizeMap.remove(bHead);
                }
            }
        }
    }
}
