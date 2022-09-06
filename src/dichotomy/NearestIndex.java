package dichotomy;

/**
 * Created by Jason Tan on 2022-09-05 19:19
 */
public class NearestIndex {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,1,1,2,2,2,2,2,2,3,3,3,3,3,3,3,5,5,5,5};
        System.out.println(test(arr, 2));
    }

    //在arr中找到目标数字且在最左侧的位置
    public static int test(int[] arr, int target){
        if(arr.length == 0 || arr == null){
            return -1;
        }
        int R = arr.length-1;
        int L = 0;
        int index = -1;
        while (L <= R){
            int mid = (L+R) / 2;
            if (arr[mid] == target){
                index = mid;
                R = mid - 1; //切换为L = mid + 1就是寻找最右侧的目标值
            } else if (arr[mid] > target){
                R = mid-1;
            } else {
                L = mid+1;
            }
        }
        return index;
    }
}
