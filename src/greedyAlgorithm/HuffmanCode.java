package greedyAlgorithm;

import java.util.PriorityQueue;

/**
 * Created by Jason Tan on 2022-09-12 15:38
 */
public class HuffmanCode {

    public static int huffmanCode(int[] arr) {
        PriorityQueue<Integer> sorted = new PriorityQueue<>();
        for (int i=0; i<arr.length; i++){
            sorted.add(arr[i]);
        }

        int sum = 0;
        int cur = 0;
        //每次拿出两个最小，然后合并再放入（合并相当于新建node作为两个最小数的parent）
        while(sorted.size() > 1){
            cur = sorted.poll() + sorted.poll();
            sum += cur;
            sorted.add(sum);
        }
        return sum;
    }
}
