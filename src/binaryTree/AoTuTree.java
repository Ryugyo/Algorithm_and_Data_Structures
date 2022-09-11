package binaryTree;

/**
 * Created by Jason Tan on 2022-09-10 16:29
 */
public class AoTuTree {
    public static void main(String[] args) {
        printAllFolds(3);
    }

    public static void printAllFolds(int N){
        //主函数1 true表示对折一次后的”1凹“
        printProcess(1, N, true);
    }

    //i代表node的层数，N代表一共多少层，down==true时凹，false时凸
    public static void printProcess(int i, int N, boolean down){
        //i大于N说明此时i的层数已经大于要求对折的次数，所以直接返回
        if (i > N){
            return;
        }
        //直接中序遍历
        printProcess(i+1, N, true);
        System.out.println(down ? "Ao" : "Tu");
        printProcess(i+1, N, false);
    }
}
