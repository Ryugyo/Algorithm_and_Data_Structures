package sortAlgorithms;

/**
 * Created by Jason Tan on 2022-06-03 16:42
 */
public class CountingSort {
    public static int[] countingSort(int[] arr){
        int max = arr[0];
        //选出arr里最大的数
        for (int i = 1; i<arr.length; i++){
            if (max < arr[i]){
                max = arr[i];
            }
        }
        //建立一个从0到max的array，然后走一遍arr计算每个数字出现了多少次
        int[] count_arr = new int[max+1];
        for (int value:arr){
            count_arr[value]++;
        }
        //把count arr里的非0的数转换成相应的index，就是sort的arr
        //例如：index 1=3，也就是1出现了3次，添加3次1
        int arr_count = 0;
        for (int i = 0; i < max+1; i++){
            while(count_arr[i] > 0){
                arr[arr_count] = i;
                arr_count++;
                count_arr[i]--;
            }
        }
        return arr;
    }
}
