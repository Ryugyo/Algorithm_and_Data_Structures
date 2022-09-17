package backTracking;

/**
 * Created by Jason Tan on 2022-09-14 21:39
 */
public class HanoiTower {

    public static void main(String[] args) {
        hanoi2(3);
    }

    public static void hanoi1(int n){
        leftToRight(n);
    }

    //从左移动到右
    public static void leftToRight(int n){
        if (n==1){
            System.out.println("Move 1 from left to right");
            return;
        }
        //从左到右的三大步：n-1从左移动到中间
        leftToMid(n-1);
        //n移动到最右
        System.out.println("Move " + n + " from left to right");
        //n-1从中间移动到最右
        midToRight(n-1);
    }

    public static void leftToMid(int n){
        if (n==1){
            System.out.println("Move 1 from left to mid");
            return;
        }

        //从左到中的三大步：n-1从左移动到右
        leftToRight(n-1);
        //n移动到中间
        System.out.println("Move " + n +" from left to mid");
        //n-1从右移动到中间
        rightToMid(n-1);
    }

    public static void rightToMid(int n){
        if (n==1){
            System.out.println("Move 1 from right to mid");
            return;
        }

        rightToLeft(n-1);
        System.out.println("Move " + n +" from right to mid");
        leftToMid(n-1);
    }

    public static void midToRight(int n){
        if (n==1){
            System.out.println("Move 1 from mid to right");
            return;
        }

        midToLeft(n-1);
        System.out.println("Move " + n +" from mid to right");
        leftToRight(n-1);
    }

    public static void midToLeft(int n){
        if (n==1){
            System.out.println("Move 1 from mid to left");
            return;
        }

        midToRight(n-1);
        System.out.println("Move " + n +" from mid to left");
        rightToLeft(n-1);
    }

    public static void rightToLeft(int n){
        if (n==1){
            System.out.println("Move 1 from right to left");
            return;
        }

        rightToMid(n-1);
        System.out.println("Move " + n +" from right to left");
        midToLeft(n-1);
    }

    //优化版
    public static void hanoi2(int n){
        if (n>0){
            func(n, "left", "right", "mid");
        }
    }

    public static void func(int n, String from, String to, String other){
        if (n==1){
            System.out.println("Move 1 from "+from+" to "+to);
        }else{
            func(n-1, from, other, to);
            System.out.println("Move "+n+" from "+from+" to "+to);
            func(n-1, other, to, from);
        }
    }
}
