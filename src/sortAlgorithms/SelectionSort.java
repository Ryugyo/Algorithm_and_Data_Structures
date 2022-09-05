package sortAlgorithms;

/**
 * Created by Jason Tan on 2022-06-02 14:48
 */
public class SelectionSort {
    public static int[] selectionSort(int[] arr){
        //选出最小的数放在最前，然后从index1开始选第二小的数，以此类推
        for(int i = 0; i<arr.length-1; i++){
            int index = i;
            for (int j = index; j <arr.length; j++){
                if (arr[j] < arr[index]){
                    index = j;
                }
            }
            if (i != index){
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }
}
