package sortAlgorithms;

import java.util.Arrays;

/**
 * Created by Jason Tan on 2022-06-03 17:30
 */
public class BucketSort {
    public static int[] bucketSort(int[] arr){
        //算出arr里最大和最小值
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i ++){
            if (arr[i] > max){
                max = arr[i];
            } else if (arr[i] < min){
                min = arr[i];
            }
        }
        //根据max和min创建多个桶，这里假设interval是10
        int bucketCount = (int) Math.floor((max-min)/10)+1;
        int[][] bucket = new int[bucketCount][0];
        //根据计算算出每个element属于哪个桶的范畴，然后塞进目标桶
        for (int i = 0; i < arr.length; i++){
            int index = (int) Math.floor((arr[i]-min)/10);
            int[] target = Arrays.copyOf(bucket[index], bucket[index].length+1);
            target[target.length-1] = arr[i];
            bucket[index] = target;
        }
        //sort每个桶，然后按照顺序把桶内的值都导入arr，完成sort
        int arrIndex = 0;
        for (int[] a : bucket){
            if (a.length <= 0){
                continue;
            }
            a = InsertionSort.insertionSort(a);
            for (int value : a){
                arr[arrIndex] = value;
                arrIndex++;
            }
        }
        return arr;
    }
}
