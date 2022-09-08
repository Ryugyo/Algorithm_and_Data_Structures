package heap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by Jason Tan on 2022-09-07 19:49
 */
public class SortArrayDistanceLessK {

    public static void main(String[] args) {
        int[] arr = new int[]{3,44,38,5,37,15,36,26,27,3,46,4,19,50,48};
        minHeapSolution(arr, 15);
        System.out.println(Arrays.toString(arr));
    }

    public static void minHeapSolution(int[] arr, int k){
        //系统自带的min-heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        //将k数目的数字构建min-heap，每次poll一个minimum到最前位置，接着继续构筑min-heap
        for (int i=0; i<arr.length; i++){
            heap.add(arr[i]);
            if (i > k){
                arr[index++] = heap.poll();
            }
        }

        //最终将heap按顺序排列
        while(!heap.isEmpty()){
            arr[index++] = heap.poll();
        }
    }
}
