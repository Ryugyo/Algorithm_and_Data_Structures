package sortAlgorithms;

import java.util.Arrays;

/**
 * Created by Jason Tan on 2022-06-08 17:18
 */
public class Main {
    public static void main(String[] args){
        int[] arr = new int[]{3,44,38,5,37,15,36,26,27,3,46,4,19,50,48};
        int[] bubbleResult = BubbleSort.bubbleSort(arr);
        int[] selectResult = SelectionSort.selectionSort(arr);
        int[] insertResult = InsertionSort.insertionSort(arr);
        int[] shellResult = ShellSort.shellSort(arr);
        int[] mergeResult = MergeSort.mergeSort(arr);
        int[] quickResult = QuickSort.quickSort(arr, 0, arr.length-1);
        int[] heapResult = HeapSort.heapSort(arr);
        int[] countResult = CountingSort.countingSort(arr);
        int[] bucketResult = BucketSort.bucketSort(arr);
        int[] radixResult = RadixSort.radixSort(arr);
        System.out.println("Bubble Sort: "+ Arrays.toString(bubbleResult));
        System.out.println("Selection Sort: "+ Arrays.toString(selectResult));
        System.out.println("Insertion Sort: "+ Arrays.toString(insertResult));
        System.out.println("Shell Sort: "+ Arrays.toString(shellResult));
        System.out.println("Merge Sort: "+ Arrays.toString(mergeResult));
        System.out.println("Quick Sort: "+ Arrays.toString(quickResult));
        System.out.println("Heap Sort: "+ Arrays.toString(heapResult));
        System.out.println("Counting Sort: "+ Arrays.toString(countResult));
        System.out.println("Bucket Sort: "+ Arrays.toString(bucketResult));
        System.out.println("Radix Sort: "+ Arrays.toString(radixResult));
    }
}
