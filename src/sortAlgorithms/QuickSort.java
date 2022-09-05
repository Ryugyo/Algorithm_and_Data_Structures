package sortAlgorithms;

/**
 * Created by Jason Tan on 2022-06-03 0:34
 */
public class QuickSort {
    public static int[] quickSort(int[] arr, int start, int end) {
        if (end > start) {
            //已知pivot左边都小于它右边都大于它，所以pivot的位置固定，只需要把pivot左边分一个sub array，右边分一个sub array，处理两个sub array即可
            int pivotIndex = partition(arr, start, end);
            quickSort(arr, start, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
        return arr;
    }
    private static int partition(int[] arr, int start, int end){
        //pivot默认为第一位
        int pivot = start;
        int index = pivot + 1;
        //和其余数对比，确保比pivot小的都扔去左边
        for (int i=index; i<=end; i++){
            if (arr[i] < arr[pivot]){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }
        int temp = arr[pivot];
        arr[pivot] = arr[index-1];
        arr[index-1] = temp;
        return index-1;
    }
}
