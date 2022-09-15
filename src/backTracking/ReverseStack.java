package backTracking;

import java.util.Stack;

/**
 * Created by Jason Tan on 2022-09-14 22:19
 */
public class ReverseStack {

    //此方法会将stack最早push进的elem返回
    public static int f(Stack<Integer> stack){
        //先pop一个出来
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        } else {
            //如果stack没空，就继续重复步骤（先pop一个出来，再把现在的放回去）
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }

    //翻转Stack
    public static void reverseStack(Stack<Integer> stack){
        //如果stack为空，返回
        if (stack.isEmpty()){
            return;
        }
        //调用f，效果是将stack最早push进的pop出，并且stack剩余元素保持不变
        int i = f(stack);
        //对于余下的stack，再次进行这样的操作（也就是每次都拿出一个处于底层的elem，直到stack为空）
        reverseStack(stack);
        //然后再把记录的i push进去，最后的一层recursion的stack为空，push进的就是旧stack中处于最上层的elem
        //当recursion返回第一层时，除了最早的i（旧stack最早的elem）以外的元素都已经翻转
        stack.push(i);
    }
}
