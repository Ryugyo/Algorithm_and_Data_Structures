package mergeSortQuestions;

import java.util.Arrays;

/**
 * Created by Jason Tan on 2022-09-07 10:55
 */
public class SmallSum_MergeSort {

    public static void main(String[] args) {
        int[] a = {1,3,4,2,5};
        int[] b = {3,2,4,5,0};
        System.out.println(smallSum(b));
    }

    public static int smallSum(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }
        return mergeProcess(arr, 0, arr.length-1);
    }

    public static int mergeProcess(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }

        int mid = (left+right)/2;
        return mergeProcess(arr, left, mid) +
                mergeProcess(arr, mid + 1, right) +
                merge(arr, left, mid, right);
    }

    public static int merge(int[] arr, int left, int mid, int right){
        int[] sortedArr = new int[right-left+1];
        int index = 0;
        int pL = left;
        int pR = mid+1;
        int result_sum = 0;

        //当左和右都不越界
        while (pL <= mid && pR <= right){
            //如果左比右小，记录一个小和
            //如果右边第n位比左大，那么从n到末位都会比左大，小和=位数*当前的左

            //result_sum += arr[pL] < arr[pR] ? 0 : (mid-pL+1); //此为逆序对问题的解
            result_sum += arr[pL] < arr[pR] ? arr[pL] * (right-pR+1) : 0;
            sortedArr[index++] = arr[pL] < arr[pR] ? arr[pL++] : arr[pR++];
        }

        //剩余的左和右
        while (pL <= mid){
            sortedArr[index++] = arr[pL++];
        }
        while (pR <= right){
            sortedArr[index++] = arr[pR++];
        }

        //将sort好的arr赋给原arr
        for (index = 0; index < sortedArr.length; index++){
            arr[left + index] = sortedArr[index];
        }
        return result_sum;
    }
}
