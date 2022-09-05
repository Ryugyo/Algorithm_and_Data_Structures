package sortAlgorithms;

/**
 * Created by Jason Tan on 2022-06-02 15:11
 */
public class InsertionSort {
    public static int[] insertionSort(int[] arr){
        //将从index 1开始之后所有的element和前面的数经行对比，把每个数插入相应的位置
        for (int i = 1; i<arr.length; i++){
            int temp = arr[i];
            int change = i;
            for (int j = i; j > 0; j--){
                if (arr[j-1] > temp){
                    arr[j] = arr[j-1];
                    change = j-1;
                }
            }
            if (change != i){
                arr[change] = temp;
            }
        }
        return arr;
    }
}
