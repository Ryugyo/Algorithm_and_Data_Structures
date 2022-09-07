package linkedList;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Jason Tan on 2022-09-06 20:34
 */
public class QueueToStack {

    public static void main(String[] args) {
        QueueStack qs = new QueueStack();
        qs.push(1);
        qs.push(2);
        qs.push(3);
        qs.push(4);
        qs.push(5);
        System.out.println(qs.pop());
        System.out.println(qs.pop());
        System.out.println(qs.pop());
        qs.push(6);
        qs.push(7);
        System.out.println(qs.pop());
        System.out.println(qs.pop());
        System.out.println(qs.pop());
        System.out.println(qs.pop());
        System.out.println(qs.pop());
    }

    public static class QueueStack{
        private Queue<Integer> data;
        private Queue<Integer> help;

        public QueueStack(){
            data = new ArrayDeque<>();
            help = new ArrayDeque<>();
        }

        public void push(int value){
            if (data.isEmpty() && help.isEmpty()) {
                data.add(value);
            } else if (data.isEmpty()){
                help.add(value);
            } else {
                data.add(value);
            }
        }

        public int pop(){
            if (help.isEmpty() && data.isEmpty()){
                System.out.println("Empty");
                return -1;
            }
            int result;
            int count = 1;
            if (help.isEmpty()) {
                int length = data.size();
                while (count < length) {
                    help.add(data.poll());
                    count++;
                }
                result = data.poll();
            } else {
                int length = help.size();
                while (count < length) {
                    data.add(help.poll());
                    count++;
                }
                result = help.poll();
            }
            return result;
        }
    }
}
