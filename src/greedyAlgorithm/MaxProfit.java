package greedyAlgorithm;

import java.util.PriorityQueue;

/**
 * Created by Jason Tan on 2022-09-12 16:11
 */
public class MaxProfit {

    //Node就相当于项目，p是利润，c是开始项目时需求的花费
    public static class Node{
        public int p;
        public int c;

        public Node(int p, int c){
            this.p = p;
            this.c = c;
        }
    }

    //k是最多能做多少项目，w是起始资金
    public static int maximizeProfit(int k ,int w, int[] Profits, int[] Capital){
        PriorityQueue<Node> minCostQ = new PriorityQueue<>();
        PriorityQueue<Node> maxCostQ = new PriorityQueue<>();

        //先把任务初始化成Node然后放入按起始资金排序的queue中
        for (int i=0; i<Profits.length; i++){
            minCostQ.add(new Node(Profits[i], Capital[i]));
        }

        for (int i=0; i<k; i++){
            //只要queue不为空并且起始要求小于目前资金数
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= w){
                maxCostQ.add(minCostQ.poll());
            }
            //如果max queue为空说明已经没有可以做的任务或者任务已经全部做完了
            if (maxCostQ.isEmpty()){
                return w;
            }
            w += maxCostQ.poll().p;
        }
        return w;
    }
}
