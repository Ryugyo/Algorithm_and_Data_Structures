package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Jason Tan on 2022-09-10 22:54
 */
public class Dijkstra {

    public static HashMap<HashMapGraph.Node, Integer> dijkstra(HashMapGraph.Node head){
        //从head出发到所有node的最小距离，key：从head出发到达key，value：最短距离
        HashMap<HashMapGraph.Node, Integer> distanceMap = new HashMap<>();
        //自己到自己的距离为0
        distanceMap.put(head,0);
        //已经求过最短距离的node就存起来以后再也不会用到
        HashSet<HashMapGraph.Node> selected = new HashSet<>();
        //获得目前最小距离的node
        HashMapGraph.Node minNode = getMinDistanceAndNode(distanceMap, selected);
        while (minNode != null){
            int distance = distanceMap.get(minNode);
            //遍历此node所有edges
            for (HashMapGraph.Edge edge : minNode.edges){
                HashMapGraph.Node toNode = edge.to;
                //如果toNode还未被加入map中，先加进来
                if (!distanceMap.containsKey(toNode)){
                    distanceMap.put(toNode, distance + edge.weight);
                }
                //如果已经加入，那么如果新的路径（distance+edge.weight）小于本来的，就替换
                distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance+edge.weight));
            }
            //for loop结束说明此node的最短距离已经被更新完毕，加入selected表
            selected.add(minNode);
            //再次将最小distance的node取出，开启新一轮循环
            minNode = getMinDistanceAndNode(distanceMap, selected);
        }

        return distanceMap;
    }

    //获取最小路径的node，并且得是没有被更新完毕的
    public static HashMapGraph.Node getMinDistanceAndNode(HashMap<HashMapGraph.Node, Integer> distanceMap, HashSet<HashMapGraph.Node> selected){
        HashMapGraph.Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<HashMapGraph.Node, Integer> entry : distanceMap.entrySet()){
            HashMapGraph.Node node = entry.getKey();
            int distance = entry.getValue();
            if (!selected.contains(node) && distance < minDistance){
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }
}
