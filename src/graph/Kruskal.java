package graph;

import java.util.*;

/**
 * Created by Jason Tan on 2022-09-10 20:55
 */
public class Kruskal {

    public static class MySets{
        //创建一个hashmap储存当前node和它对应的set
        public HashMap<HashMapGraph.Node, List<HashMapGraph.Node>> setMap;

        //初始化时把graph里所有的node都建立一个list然后储存在hashmap中
        public MySets(List<HashMapGraph.Node> nodes){
            for (HashMapGraph.Node cur: nodes){
                //一开始所有node的对应set就只有包含他们自己的set
                List<HashMapGraph.Node> set = new ArrayList<HashMapGraph.Node>();
                set.add(cur);
                setMap.put(cur, set);
            }
        }

        //设置一个method，判断两个node是否在一个集合里
        public boolean isSameSet(HashMapGraph.Node from, HashMapGraph.Node to){
            //提取from Node的set和to Node的set，如果两个set指向同一个内存地址就说明两个set是一样的，返回true
            List<HashMapGraph.Node> fromSet = setMap.get(from);
            List<HashMapGraph.Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        //设置一个method，合并A和B所在两个set
        public void union(HashMapGraph.Node from, HashMapGraph.Node to){
            List<HashMapGraph.Node> fromSet = setMap.get(from);
            List<HashMapGraph.Node> toSet = setMap.get(to);
            //提取from和to两个node所在的set后，把to的set里的node全部给from，再把toNode的set指向fromSet
            //如此就完成了两个set合并并且from和to都指向同一个set的操作
            for (HashMapGraph.Node toNode : toSet){
                fromSet.add(toNode);
                setMap.put(toNode, fromSet);
            }
        }
    }

    public static Set<HashMapGraph.Edge> kruskalMST(HashMapGraph.Graph graph){
        List<HashMapGraph.Node> list = new ArrayList<HashMapGraph.Node>(graph.nodes.values());
        MySets mySets = new MySets(list);

        //将所有edges按weight储存
        PriorityQueue<HashMapGraph.Edge> queue = new PriorityQueue<>();
        queue.addAll(graph.edges);

        Set<HashMapGraph.Edge> result = new HashSet<>();
        while (!queue.isEmpty()){
            HashMapGraph.Edge cur = queue.poll();
            //如果两个edge连接的两个node from和to没有共享一个set，就说明此edge不构成loop可以添加
            if (!mySets.isSameSet(cur.form, cur.to)){
                result.add(cur);
                mySets.union(cur.form, cur.to);
            }
        }
        return result;
    }
}
