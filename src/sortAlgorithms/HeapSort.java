package sortAlgorithms;

/**
 * Created by Jason Tan on 2022-06-03 15:01
 */
public class HeapSort {
    public static int[] heapSort(int[] arr){
        //通过length计算总共有多少subtree的root
        //例如length=6，总共就有3个node作为root，index分别是2，1，0
        //将这些root进行heapify
        for(int i = arr.length/2-1; i>=0; i--){
            heapify(arr, arr.length, i);
        }
        //将已经maxheap的数组的root和尾部替换（相当于把最大数放在array末尾）
        //接着将新的array进行heapify
        for(int i = arr.length-1; i>=0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
        return arr;
    }

    public static void heapify(int[] arr, int length, int root){
        //给一个root的index，计算左边node和右边node
        int largest = root;
        int left_node = root*2+1;
        int right_node = root*2+2;

        //如果存在左边node，看看是否大于root的值
        if (left_node < length && arr[largest] < arr[left_node]){
            largest = left_node;
        }
        //如果存在右边node，看看是否大于largest的值
        if (right_node < length && arr[largest] < arr[right_node]){
            largest = right_node;
        }
        //如果largest和root不符说明左或右node更大，替换
        if (largest != root){
            int temp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = temp;
            //如果有替换发生说明subtree有了变动，把subtree recursion继续heapify
            heapify(arr, length, largest);
        }
    }
}
