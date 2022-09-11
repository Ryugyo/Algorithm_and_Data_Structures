package graph;

import java.util.*;

/**
 * Created by Jason Tan on 2022-09-10 17:37
 */
public class HashMapGraph {

    public static class Node{
        //vertex的结构包含：value值，有多少入路，有多少出路，所有出路链接到的vertex，所有edges
        public int value;
        public int in;
        public int out;
        public ArrayList<Node> nexts;
        public ArrayList<Edge> edges;


        public Node(int value){
            this.value = value;
            in = 0;
            out = 0;
            nexts = new ArrayList<>();
            edges = new ArrayList<Edge>();
        }
    }

    public static class Edge{
        //edge有权重，没权重的话就0
        public int weight;
        public Node form;
        public Node to;

        public Edge(int weight, Node from, Node to){
            this.weight = weight;
            this.form = from;
            this.to = to;
        }
    }

    public static class Graph{
        //使用hashmap记录所有的nodes（vertex），hashset记录所有的edge
        HashMap<Integer, Node> nodes;
        HashSet<Edge> edges;

        public Graph(){
            nodes = new HashMap<>();
            edges = new HashSet<>();
        }
    }

    //BFS
    public static void BFS(Node node){
        if (node == null){
            return;
        }
        //BFS靠queue实现，hashset是为了保证一个node不重复进queue（因为graph不像tree，是可能有环结构的）
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();

        queue.add(node);
        set.add(node);
        //如果queue不为空
        while (!queue.isEmpty()){
            //弹出一个node后打印
            Node cur = queue.poll();
            System.out.println(cur.value);
            //如果此node的nexts列表不为空，遍历每一个
            for (Node next : cur.nexts){
                //如果set里没有说明是第一次visit这个node，加入queue中
                if(!set.contains(next)){
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }

    //DFS
    public static void DFS(Node node){
        if (node == null){
            return;
        }

        //DFS靠stack实现，同样需要一个hashset来储存一个node是否visit过
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);

        System.out.println(node.value);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            for (Node next : cur.nexts){
                //和BFS的小区别，如果set里没有next，那么首先重新把cur压回stack，再压next
                if (!set.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    //必须确保往一条路走到黑再回头，所以一旦发现新的没visit过的next，先break
                    break;
                }
            }
        }
    }

    //Topological Sort
    public static List<Node> topologicalSort(Graph graph){
        //创建一个hashmap记录node和它剩余的入度（有多少其他node指向它）
        HashMap<Node, Integer> inMap = new HashMap<>();
        //只有剩余入度为0才可以加入set
        Queue<Node> zeroInQueue = new LinkedList<>();

        //先把graph遍历一遍把所有node和其入度记录，再把一开始入度就0的点加入set
        for(Node node : graph.nodes.values()){
            inMap.put(node, node.in);
            if (node.in == 0){
                zeroInQueue.add(node);
            }
        }

        //简历result的arraylist
        List<Node> result = new ArrayList<>();
        //将所有入度为0的node遍历
        while (!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            //因为此node的入度为0（也就是不需要任何前置node）所以直接加入result里
            result.add(cur);
            //对于此node的所有next，将他们的入度减去1（相当于这些node的前置条件-1）
            for (Node next : cur.nexts){
                inMap.put(next, inMap.get(next) - 1);
                //如果减1后某些node的入度变0，说明也不需要前置条件了，加入set等待遍历
                if (inMap.get(next) == 0){
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
