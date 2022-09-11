package graph;

import java.util.HashMap;

/**
 * Created by Jason Tan on 2022-09-10 18:28
 */
public class MatrixToGraph {

    public static HashMapGraph.Graph createGraph(Integer[][] matrix){
        HashMapGraph.Graph graph = new HashMapGraph.Graph();
        //matrix结构是：[x,y,z]，x指起点node，y指到达node，z指权重
        for (int i = 0; i < matrix.length; i++){
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];
            //如果graph里用hashmap储存的所有node信息里没有from或者to，添加
            if (!graph.nodes.containsKey(from)){
                graph.nodes.put(from, new HashMapGraph.Node(from));
            }
            if (!graph.nodes.containsKey(to)){
                graph.nodes.put(from, new HashMapGraph.Node(to));
            }
            HashMapGraph.Node fromNode = graph.nodes.get(from);
            HashMapGraph.Node toNode = graph.nodes.get(to);
            //创建两node之间的edge
            HashMapGraph.Edge newEdge = new HashMapGraph.Edge(weight, fromNode, toNode);
            //修改俩node信息，将from的next添加一个to，再把out数值+1；把to的in数值+1
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            //再将新的edge添加进from的edges集合里
            fromNode.edges.add(newEdge);
            //给graph的hashset的edges集合里也添加newedge
            graph.edges.add(newEdge);
        }
        return graph;
    }
}
