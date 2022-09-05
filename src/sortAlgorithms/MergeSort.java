package sortAlgorithms;

import java.util.Arrays;

/**
 * Created by Jason Tan on 2022-06-02 19:57
 */
public class MergeSort {
    public static int[] mergeSort(int[] arr){
        if (arr.length < 2){
            return arr;
        }
        //将arr分成左和右两个sub array
        int[] left = Arrays.copyOfRange(arr, 0, arr.length/2);
        int[] right = Arrays.copyOfRange(arr, arr.length/2, arr.length);
        //用recursion继续分
        left = mergeSort(left);
        right = mergeSort(right);
        //所有的sub array都有一个规则那就是按increasing排序，所以将left和right合并的方法就是对比同index位取小的放置在前，大的紧随其后
        int [] result = new int[left.length+right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0){
            if (left[0] <= right[0]) {
                result[i] = left[0];
                i++;
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i] = right[0];
                i++;
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        //如果左或右还有剩余的element，说明肯定比合并array中的所有数都大，加入末尾
        while (left.length > 0){
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0){
            result[i] = right[0];
            i++;
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }
}
