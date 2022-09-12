package greedyAlgorithm;

/**
 * Created by Jason Tan on 2022-09-12 16:47
 */
public class NQueens {

    public static int num1(int n){
        if (n<1){
            return 0;
        }
        //record相当于记录皇后棋子具体在第n行中的哪个位置
        //比如record[0] = 1，表示第0行第1列有皇后
        int[] record = new int[n];
        return process(0, record, n);
    }

    //目前来到了第i行，说明0到i-1行都已经摆过了棋子（潜台词：0到i-1行的皇后都不共行共列共斜线）
    //n代表一共有多少行，返回值是合理的摆法有多少种
    public static int process(int i, int[] record, int n){
        //base case如果i=n说明已经到最后一行了，那么至此已经有了一种合理的摆法
        if (i == n){
            return 1;
        }

        int res = 0;
        //对于每一行每一个位置，看看有多少是合理的，进入一个合理的，看看在此基础上下一行多少合理
        for (int j=0; j<n; j++){
            //尝试当前i行所有的列j，看看是否合理
            if (isValid(record, i, j)){
                //如果合理的话，就储存，然后在下这一步棋的基础上开始看下一行
                record[i] = j;
                res += process(i+1, record, n);
            }
        }
        return res;
    }

    public static boolean isValid(int[] record, int i, int j){
        //对于i行之前所有行
        for (int k=0; k<i; k++){
            //如果和之前某一行共列（record[k]==j）或共斜线（行减列的绝对值）
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)){
                return false;
            }
        }
        return true;
    }
}
