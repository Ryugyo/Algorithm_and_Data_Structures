package sortAlgorithms;

import java.util.Arrays;

/**
 * Created by Jason Tan on 2022-06-03 17:46
 */
public class RadixSort {
    public static int[] radixSort(int[] arr){
        //计算arr里最大的数
        int max = arr[0];
        for (int value : arr){
            if (value > max){
                max = value;
            }
        }
        //计算最大的数的最高位数
        int max_digit = 0;
        while (max >= 1){
            max/=10;
            max_digit++;
        }

        int mod = 10;
        int dev = 1;
        for (int i = 0; i < max_digit; i++, dev *=10, mod *=10){
            int[][] counter = new int[mod*2][0];
            for(int j=0; j<arr.length; j++){
                int bucket = ((arr[j]%mod)/dev) + mod;
                counter[bucket] = Arrays.copyOf(counter[bucket], counter[bucket].length+1);
                counter[bucket][counter[bucket].length-1] = arr[j];
            }

            int pos = 0;
            for (int[] bucket : counter){
                for (int value : bucket){
                    arr[pos] = value;
                    pos++;
                }
            }
        }
        return arr;
    }
}
