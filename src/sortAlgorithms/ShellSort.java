package sortAlgorithms;

/**
 * Created by Jason Tan on 2022-06-02 16:10
 */
public class ShellSort {
    public static int[] shellSort(int[] arr){
        int temp;
        //insertion的进化版，设置一个gap，将间隔gap的数组成sub array然后进行insertion，最后gap缩小为1（也就是间隔1的每个数，也就是整个arr）进行最后的insertion
        for (int gap = arr.length/2; gap > 0; gap /= 2){
            for (int i = gap; i < arr.length; i++){
                temp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > temp){
                    arr[j+gap] = arr[j];
                    j -= gap;
                }
                arr[j+gap] = temp;
            }
        }
        return arr;
    }
}
