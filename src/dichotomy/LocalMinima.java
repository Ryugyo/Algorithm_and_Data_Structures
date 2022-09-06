package dichotomy;

/**
 * Created by Jason Tan on 2022-09-05 19:40
 */
public class LocalMinima {
    //局部最小的定义：只要值比左边和右边都小那么就是局部最小
    public static void main(String[] args) {
        int[] arr = {10,2,4,8,9,4,5};
        System.out.println(localMinima(arr));
    }

    public static int localMinima(int[] arr){
        if (arr.length == 0){
            return -1;
        }
        if (arr.length == 1){
            return 0;
        }
        if (arr.length == 2){
            return arr[0] > arr[1] ? 1 : 0;
        }
        //逻辑：先找mid，如果mid比左右两边都小那么mid自身就是localminima
        //如果mid比左侧大，那么index 0到mid之间肯定存在localminima，直接二分法看左侧
        //如果mid比右侧大，那么index mid到length-1之间肯定存在localminima，直接二分法看右侧
        int L = 0;
        int R = arr.length-1;
        int mid = -1;
        while (L < R){
            mid = (L+R) / 2;
            if (mid == 0 || mid == arr.length){
                return mid;
            } else if (arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1]){
                return mid;
            } else if(arr[mid] > arr[mid+1]){
                L = mid+1;
            } else {
                R = mid-1;
            }
        }
        return L;
    }
}
