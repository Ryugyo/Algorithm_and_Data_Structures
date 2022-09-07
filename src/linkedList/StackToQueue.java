package linkedList;

import java.util.Stack;

/**
 * Created by Jason Tan on 2022-09-06 20:09
 */
public class StackToQueue {

    public static void main(String[] args) {
        StackQueue sq = new StackQueue();
        sq.push(1);
        sq.push(2);
        sq.push(3);
        sq.push(4);
        System.out.println(sq.pop());
        System.out.println(sq.pop());
        System.out.println(sq.pop());
        sq.push(5);
        sq.push(6);
        System.out.println(sq.pop());
        System.out.println(sq.pop());
        System.out.println(sq.pop());
        System.out.println(sq.pop());
    }

    public static class StackQueue{
        private Stack<Integer> data;
        private Stack<Integer> help;

        public StackQueue(){
            data = new Stack<>();
            help = new Stack<>();
        }

        public void push(int value){
            data.push(value);
            if (help.empty()){
                while(!data.empty()){
                    help.push(data.pop());
                }
            }
        }

        public int pop(){
            if (help.empty()){
                System.out.println("Empty");
                return -1;
            }
            int result = help.pop();
            if (help.empty()){
                while(!data.empty()){
                    help.push(data.pop());
                }
            }
            return result;
        }
    }
}
