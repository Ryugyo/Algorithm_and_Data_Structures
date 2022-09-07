package linkedList;

import java.util.Stack;

/**
 * Created by Jason Tan on 2022-09-06 16:46
 */
public class GetMinStack {

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(1);
        ms.push(2);
        ms.push(3);
        ms.push(4);
        ms.push(5);
        if (ms.getMin() instanceof Integer){
            System.out.println(ms.getMin());
        }
    }

    public static class MinStack extends Stack {
        private final Stack min_stack;
        private int min;

        public MinStack() {
            super();
            min_stack = new Stack();
        }

        public void push(int value) {
            if(isEmpty() || value < min){
                min = value;
                min_stack.push(value);
            } else {
                min_stack.push(min);
            }
            super.push(value);
        }

        @Override
        public Object pop(){
            min_stack.pop();
            return super.pop();
        }

        public Object getMin(){
            return min_stack.get(min_stack.size()-1);
        }
    }

}
