package dichotomy;

import java.util.Arrays;

/**
 * Created by Jason Tan on 2022-09-05 18:32
 */
public class NumberExists {
    public static void main(String[] args) {
        NumberExists ne = new NumberExists();
        int[] arr = {1,4,5,7,8,9,11,14,16,18};
        System.out.println(ne.numberExists(arr, 10));
        System.out.println(ne.exist(arr, 10));
    }

    public boolean numberExists(int[] arr, int target){
        if (arr.length == 0){
            return false;
        }
        int mid = arr.length/2;
        if (target > arr[mid]){
            return numberExists(Arrays.copyOfRange(arr, mid+1, arr.length), target);
        } else if (target == arr[mid]) {
            return true;
        } else{
            return numberExists(Arrays.copyOfRange(arr, 0, mid), target);
        }
    }

    public boolean exist(int[] arr, int num){
        if (arr == null || arr.length == 0){
            return false;
        }
        int L = 0;
        int R = arr.length-1;
        int mid = 0;

        while (L<R){
            mid = L + ((R-L) >> 1); // mid = (L+R) / 2
            if (arr[mid] == num){
                return true;
            } else if(arr[mid] > num){
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return arr[L] == num;
    }
}
