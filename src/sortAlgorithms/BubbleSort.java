package sortAlgorithms;

/**
 * Created by Jason Tan on 2022-06-02 14:17
 */
public class BubbleSort {
    public static int[] bubbleSort(int[] arr){
        //从0到倒数第二位，将arr里的element和它之后的一位作比较，如果后比前小，交换
        for(int i = 0; i < arr.length-1; i++){
            for(int j = 1; j < arr.length; j++){
                if (arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }
}
