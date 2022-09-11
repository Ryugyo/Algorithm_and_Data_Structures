package graph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by Jason Tan on 2022-09-10 22:21
 */
public class Prim {

    public static Set<HashMapGraph.Edge> primMST(HashMapGraph.Graph graph){
        //解锁node的所有其他edge
        PriorityQueue< HashMapGraph.Edge> queue = new PriorityQueue<>();
        //已经遍历到的node
        HashSet<HashMapGraph.Node> set = new HashSet<>();
        //最终返回的结果
        Set<HashMapGraph.Edge> result = new HashSet<>();

        //对于graph里所有node
        for (HashMapGraph.Node node : graph.nodes.values()){
            //如果没有遍历过，加入set
            if (!set.contains(node)){
                set.add(node);
                //再把它所有的edge放入队列中
                for (HashMapGraph.Edge edge : node.edges){
                    queue.add(edge);
                }
                //从优先级队列里拿出weight最小的edge，考察
                while (!queue.isEmpty()){
                    HashMapGraph.Edge edge = queue.poll();
                    HashMapGraph.Node toNode = edge.to;
                    //如果这个edge的to Node是一个新node，那么就加入set，然后再把此edge加入result
                    if (!set.contains(toNode)){
                        set.add(toNode);
                        result.add(edge);
                        //然后再把to Node发散出来的所有edge加入edge表
                        queue.addAll(toNode.edges);
                    }
                }
            }
        }
        return result;
    }

}
